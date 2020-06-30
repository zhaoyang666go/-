package zhaoyang.study.java8.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
* CyclicBarrier 跟 CountDownLatch 正相反
* Case：7个人开会，人都到期了才开始
* */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("人到齐了，开会！");
        });

        for (int i=1; i<=7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 到!");

                try {
                    cyclicBarrier.await();  //人没到齐就等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
