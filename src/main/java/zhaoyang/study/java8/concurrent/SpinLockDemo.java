package zhaoyang.study.java8.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhaoyang
 * @Date 2020/7/1 - 9:06
 *
 * 实现一个自旋锁
 * 好处：循环尝试获取资源，不阻塞
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicThread = new AtomicReference<>(); //原子引用线程，初试值为null

    public void myLock(){
        Thread thread = Thread.currentThread(); //当前线程
        System.out.println(thread.getName() + "\t comes in");

        while (!atomicThread.compareAndSet(null, thread)){  //获取锁

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicThread.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t invoked myUnlock()");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);  //暂停3s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);  //暂停1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        }, "BB").start();
    }
}
