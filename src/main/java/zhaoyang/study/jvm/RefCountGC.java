package zhaoyang.study.jvm;

/*
* GC 算法之引用计数法的缺点case
* 循环引用case
* */
public class RefCountGC {
    private byte[] bigSize = new byte[2 *1024 * 1024];  //这个属性唯一作用就是占内存
    Object instance = null;

    public static void main(String[] args) {
        RefCountGC A = new RefCountGC();
        RefCountGC B = new RefCountGC();
        A.instance = B;
        B.instance = A;
        A = null;
        B = null;

        System.gc();
    }
}
