package zhaoyang.study.java8.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    private int a = 0;

    public synchronized void increment() throws InterruptedException {
        //判断
        while (0 != a) {
            this.wait();
        }

        //干活
        a += 1;
        System.out.println(Thread.currentThread().getName() + "\t" + a);

        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        //判断
        while (0 == a) {
            this.wait();
        }

        //干活
        a -= 1;
        System.out.println(Thread.currentThread().getName() + "\t" + a);

        //通知
        this.notifyAll();
    }
}

class Resource2 {
    private int a = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (0 != a) {
//                this.wait();    //与 synchronized 匹配使用
                condition.await();
            }

            a += 1;
            System.out.println(Thread.currentThread().getName() + "\t" + a);

            //            this.notifyAll();   //与 synchronized 匹配使用
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (0 == a) {
                condition.await();
            }

            a -= 1;
            System.out.println(Thread.currentThread().getName() + "\t" + a);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/*
* 生产者消费者问题
* 题目：现在两个线程，操作初始值为0的一个变量
*   实现一个线程对该变量加1，另一个线程对该变量减1
*   实现交替，来10轮
*
* 1. 高聚低合的前提下，线程操作资源类
* 2. 判断/干活/通知
* 3. 防止虚假唤醒(判断用 while)
*
* 总结：多线程编程套路 + while 判断 + 新版写法
* */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Resource resource = new Resource(); //资源类
        Resource2 resource2 = new Resource2();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                resource2.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                resource2.decrement();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                resource2.increment();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i=1; i<=10; i++) {
                resource2.decrement();
            }
        }, "D").start();
    }
}
