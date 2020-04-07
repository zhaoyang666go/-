package zhaoyang.study.jvm;

import java.util.Random;

/*
* 测试堆参数
* 通过 IDEA 调整 JVM 的堆参数
* */
public class Assistant {
    public static void main(String[] args) {
//        Runtime rt = Runtime.getRuntime();
//
//        System.out.println("CPU处理器数量：" + rt.availableProcessors());
//
//        long maxMemory = rt.maxMemory();  //JVM试图使用的最大内存量
//        long totalMemory = rt.totalMemory();    //JVM内存总量
//        System.out.println("-XMX:MAX_MEMORY = " + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) +
//                "MB");
//        System.out.println("-XMS:TOTAL_MEMORY = " + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");

//        String str = "JVM-Heap";
//        while (true) {
//            str += str + new Random().nextInt(88888888) + new Random().nextInt(99999999);
//        }

        byte[] bytes = new byte[40 * 1024 * 1024];
    }
}
