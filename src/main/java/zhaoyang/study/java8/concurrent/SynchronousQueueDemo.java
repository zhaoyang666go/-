package zhaoyang.study.java8.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyang
 * @Date 2020/7/4 - 8:31
 *
 * 阻塞队列 SynchronousQueue 演示
 * 定制功能：定制后才生成，有消费才有生成
 * 同步功能：生产一个消费一个，不消费就不生产
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }  //暂停3s
                System.out.println(Thread.currentThread().getName() + "\t take" + blockingQueue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }  //暂停3s
                System.out.println(Thread.currentThread().getName() + "\t take" + blockingQueue.take());

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }  //暂停3s
                System.out.println(Thread.currentThread().getName() + "\t take" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
