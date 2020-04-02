package zhaoyang.study.danlimoshi.ehanshi;

/*
* volatile 关键字
* volatile 在Java并发编程中常用于保持内存可见性和防止指令重排序
* 内存可见性：所有线程都能看到共享内存的最新状态
* 防止指令重排：在基于偏序关系的 Happens-Before 内存模型中，大大提高线程执行效率
* */

/*
* 双重校验锁，线程安全，值得推荐
* */
public class Singleton6 {
    private static volatile Singleton6 instance;

    private Singleton6() {}

    public static Singleton6 getInstance() {
        if (null == instance) {
            synchronized (Singleton6.class) {
                if (null == instance) {
                    instance = new Singleton6();
                }
            }
        }

        return instance;
    }
}
