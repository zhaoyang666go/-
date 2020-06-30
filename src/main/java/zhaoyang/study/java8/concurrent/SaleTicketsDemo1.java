package zhaoyang.study.java8.concurrent;

/*
* 多线程：线程 操作 资源类
* */

/*
* 三个售票员 卖 30张票
* */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 30;

    Lock lock = new ReentrantLock();


    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) +
                        "张票，余票" + number + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTicketsDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

//        new Thread(() -> {for (int i=0; i<=40; i++) {ticket.sale();}}, "A").start();
        new Thread(() -> {for (int i=0; i<=40; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (int i=0; i<=40; i++) {ticket.sale();}}, "B").start();
        new Thread(() -> {for (int i=0; i<=40; i++) {ticket.sale();}}, "C").start();



//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
//        Thread t3 = new Thread();

        /*new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i=1; i<=40; i++) {
                    ticket.sale();
                }
            }
        }, "1号售票员").start();

        new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i=1; i<=40; i++) {
                    ticket.sale();
                }
            }
        }, "2号售票员").start();

        new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i=1; i<=40; i++) {
                    ticket.sale();
                }
            }
        }, "3号售票员").start();*/
    }
}
