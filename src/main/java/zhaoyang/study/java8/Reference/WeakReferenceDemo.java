package zhaoyang.study.java8.Reference;

import org.springframework.cglib.core.WeakCacheKey;

import java.lang.ref.WeakReference;

/**
 * @author zhaoyang
 * @Date 2020/7/7 - 15:01
 *
 * 弱引用：只要gc，就被回收
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakCacheKey<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("gc====================");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
