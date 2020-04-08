package zhaoyang.study.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
* Semaphone 的功能：“抢车位”，控制并发线程数
* Case：七个人抢三个车位，每人都要停一次，停3秒走人
* */
public class SemaphoneDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); //模拟资源类有3个空车位

        for (int i=1; i<=7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();    //占用
                    System.out.println(Thread.currentThread().getName() + "\t 占用了1个车位");

                    try { TimeUnit.SECONDS.sleep(3);  //停3秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "\t 开车走人");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();    //释放资源
                }
            }, String.valueOf(i)).start();
        }
    }
}
