package zhaoyang.study.java8.Reference;

import java.lang.ref.SoftReference;

/**
 * @author zhaoyang
 * @Date 2020/7/7 - 14:41
 *
 * 软引用
 * 内存够用不回收，内存不够就回收
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
//        softRef_Memory_Enouth();

        softRef_Memory_NotEnough();
    }

    /*
    * 内存不够
    * JVM配置小内存，创建大对象，手动OOM
    * -Xms5m -Xmx5m -XX:+PrintGCDetails
    * */
    public static void softRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bs = new byte[30 * 1024 * 1024];
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    /*
    * 内存够用，不回收
    * */
    public static void softRef_Memory_Enouth(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }
}