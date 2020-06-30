package zhaoyang.study.java8.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhaoyang
 * @Date 2020/6/30 - 9:44
 *
 * ABA问题解决：带时间戳（版本号）的原子引用
 */
public class AtomicStampedReferenceDemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("=========ABA问题演示===========");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);    //A——>B
            atomicReference.compareAndSet(101, 100);    //B——>A
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);  //暂停1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 2020) + "\t" + atomicReference.get());
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);  //暂停2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=========ABA问题解决===========");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);  //暂停1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100,
                    101,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t 第二次版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,
                    100,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t 第三次版本号：" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stamp);

            try {
                TimeUnit.SECONDS.sleep(3);  //暂停3s，保证t3线程完成ABA操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = atomicStampedReference.compareAndSet(100,
                    2020,
                    stamp,
                    stamp+1);
            System.out.println(Thread.currentThread().getName() + "\t 修改结果：" + result + "\t"
                    + "当前最新版本号：" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t 当前最新值：" + atomicStampedReference.getReference());
        }, "t4").start();
    }
}
