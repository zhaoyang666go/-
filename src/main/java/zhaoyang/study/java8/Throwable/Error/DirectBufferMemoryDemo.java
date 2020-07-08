package zhaoyang.study.java8.Throwable.Error;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyang
 * @Date 2020/7/8 - 10:52
 *
 * 本地内存溢出
 *
 * JVM参数：
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("Java能够占用的最大内存："
                + (sun.misc.VM.maxDirectMemory() / (double)1024 / 1024)
                + "MB");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  //暂停3s

        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
