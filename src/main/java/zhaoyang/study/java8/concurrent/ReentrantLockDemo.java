package zhaoyang.study.java8.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoyang
 * @Date 2020/6/30 - 17:25
 *
 * synchronized和ReentrantLock是典型的可重入锁（递归锁）
 */

class Phone02{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail()");
    }
}

class Phone03 implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail()");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        lock.lock();    //加锁解锁必须配对出现，加锁几次就得解锁几次，否则会死锁
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
//        testSync();

        testReentrantLock();
    }

    /*测试ReentrantLock是可重入锁*/
    private static void testReentrantLock() {
        Phone03 phone03 = new Phone03();
        Thread t3 = new Thread(phone03, "t3");
        Thread t4 = new Thread(phone03, "t4");
        t3.start();
        t4.start();
    }

    /*synchronized是可重入锁*/
    private static void testSync() {
        Phone02 phone02 = new Phone02();

        new Thread(() -> {
            try {
                phone02.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone02.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
