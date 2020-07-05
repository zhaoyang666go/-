package zhaoyang.study.java8.concurrent;

import java.util.concurrent.*;

/**
 * @author zhaoyang
 * @Date 2020/7/5 - 9:11
 *
 * 第4种获取线程的方法：从池中取
 *  1. 继承Thread类
 *  2. 实现Runnable接口（没有返回值，不抛异常）
 *  3. 实现Callable接口（有返回值，会抛异常）
 *  4. 从线程池中获取
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
//        ExecutorsThreadPool();

        final int maximumPoolSize = Runtime.getRuntime().availableProcessors() + 1;

        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                maximumPoolSize,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),   //链表阻塞队列，长度为3
                Executors.defaultThreadFactory(),   //默认的线程工程
//                new ThreadPoolExecutor.AbortPolicy()    //默认的拒绝策略，拒绝时直接抛异常
//                new ThreadPoolExecutor.CallerRunsPolicy()   //调用者执行，任务回退给调用线程池的线程执行
//                new ThreadPoolExecutor.DiscardOldestPolicy()    //抛弃等待队列中队尾任务，当前任务加入队尾等待执行
                new ThreadPoolExecutor.DiscardPolicy()  //直接拒绝执行该任务
                );
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务......");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }  //暂停1s

                    System.out.println(Thread.currentThread().getName() + "\t业务办理完成");
                });
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    /*
    * 仅用于熟悉API
    * 生产过程中自定义线程池
    * */
    private static void ExecutorsThreadPool() {
        //        ExecutorService executor = Executors.newFixedThreadPool(5); //创建一个5线程的池子
//        ExecutorService executor = Executors.newSingleThreadExecutor(); //池中仅1个线程
        ExecutorService executor = Executors.newCachedThreadPool(); //不固定，弹性线程池
        try {
            for (int i=1; i<=10; i++){
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  //暂停0.3s
            }
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           executor.shutdown();
        }
    }
}
