package zhaoyang.study.java8.GC;

/**
 * @author zhaoyang
 * @Date 2020/7/6 - 15:27
 *
 * 测试带参数运行JVM
 * IDEA集成环境设置参数并在终端查看
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        long totalMemory = Runtime.getRuntime().totalMemory();  //JVM内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();  //JVM尝试使用的最大内存量
        System.out.println("Total-Memory: " + totalMemory + "字节、" + (totalMemory/(double)1024/1024) + "MB");
        System.out.println("Max-Memory: " + maxMemory + "字节、" + (maxMemory/(double)1024/1024) + "MB");

        System.out.println("******HelloGC");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
