package zhaoyang.study.java8.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    //标识位
    private int number = 1; //A: 1; B: 2; C: 3

    //一把锁配多把钥匙
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //判断
            while (1 != number) {
                c1.await();
            }

            //干活
            for (int i=1; i<=5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //通知
            number = 2; //先改标识位
            c2.signal();    //通知下一个线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (2 != number) {
                c2.await();
            }

            //干活
            for (int i=1; i<=10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //通知
            number = 3; //先改标识位
            c3.signal();    //通知下一个线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (3 != number) {
                c3.await();
            }

            //干活
            for (int i=1; i<=15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //通知
            number = 1; //先改标识位
            c1.signal();    //通知下一个线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/*
* 备注：多线程之间按顺序调用，实现 A->B->C
*
* 三个线程启动，要求如下：
* AA打印5次，BB打印10次，CC打印15次
* 然后
* AA打印5次，BB打印10次，CC打印15次
* 重复10轮
* */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                shareData.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                shareData.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                shareData.print15();
            }
        }, "CC").start();
    }
}
