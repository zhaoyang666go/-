package zhaoyang.study.java8.concurrent;

import java.util.concurrent.*;

/*
* 常用线程池API
*
* CPU密集型程序的线程池最大线程数一般设置为本机处理器数加1或2
* I/O密集型的线程池最大线程数一般设置为：CPU可用核心数  / （1-阻塞系数）
*   计算密集型程序的阻塞系数为0，IO密集型程序的阻塞系数接近1
* */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        initThreadPool();
        final int maximumPoolSize = Runtime.getRuntime().availableProcessors() + 1; //一般最大线程数是本机处理器数+1到2

        ExecutorService threadPool = new ThreadPoolExecutor(2, maximumPoolSize, 2L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());    //抛异常以示拒绝
//                new ThreadPoolExecutor.CallerRunsPolicy());   //回退给调用线程池的线程去执行任务
//                new ThreadPoolExecutor.DiscardPolicy()  //抛弃任务，不予执行
//                new ThreadPoolExecutor.DiscardOldestPolicy()    //抛弃队列中等待最久的任务，将当前任务加入队列，尝试再次提交
//        );

        try {
            for (int i=1; i<=10; i++) {
                threadPool.execute(() -> {  //使用
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } finally {
            threadPool.shutdown();  //关闭
        }
    }

    /*
    * 仅用于熟悉API
    * 实际开发中，一般使用ThreadPoolExecutor自定义线程池
    * */
    private static void initThreadPool() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);   //一池5个受理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();   //池中只有一个工作线程
        ExecutorService threadPool = Executors.newCachedThreadPool();   //一池n线程，可扩容

        try {
            //模拟10个任务需要线程池来处理，池中有5个工作线程
            for (int i=1; i<=10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);  //手动减速
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } finally {
            threadPool.shutdown();  //关闭线程池
        }
    }
}
