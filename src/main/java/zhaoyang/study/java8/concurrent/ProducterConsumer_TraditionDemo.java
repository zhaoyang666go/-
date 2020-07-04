package zhaoyang.study.java8.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoyang
 * @Date 2020/7/4 - 9:16
 *
 * 生产者-消费者
 * 传统版
 *
 * 题目：一个初始值为0的变量，两个线程交替操作，一个加1一个减1，来5轮
 */

class ShareData02{
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{

        lock.lock();
        try{
            while (number != 0){
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws Exception{

        lock.lock();
        try{
            while (number == 0){
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

public class ProducterConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData02 shareData02 = new ShareData02();

        new Thread(() -> {
            for (int i=1; i<=5; i++){
                try {
                    shareData02.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i=1; i<=5; i++){
                try {
                    shareData02.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
