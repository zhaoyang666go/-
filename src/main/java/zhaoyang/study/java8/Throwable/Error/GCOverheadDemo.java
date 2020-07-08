package zhaoyang.study.java8.Throwable.Error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyang
 * @Date 2020/7/8 - 9:29
 *
 * JVM参数：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize5m
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 连续多次GC，只回收不到2%的极端情况抛出这个错误
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e){
            System.out.println("******i: " + i);
            e.printStackTrace();
            throw e;
        }
    }
}
