package zhaoyang.study.java8.Reference;

/**
 * @author zhaoyang
 * @Date 2020/7/7 - 14:31
 *
 * 强引用：只要某个对象有强引用，即使OOM，也不回收
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();   //强引用
        System.out.println(o1);
        Object o2 = o1; //引用赋值
        o1 = null;  //置空
        System.gc();
        System.out.println(o2);
    }
}
