package zhaoyang.study.java8.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaoyang
 * @Date 2020/6/29 - 16:53
 *
 * CAS == CompareAndSet 比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2021) + "\t current data: " + atomicInteger.get());
    }
}
