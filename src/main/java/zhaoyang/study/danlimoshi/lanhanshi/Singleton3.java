package zhaoyang.study.danlimoshi.lanhanshi;

/*
* 示例3
* 线程不安全，会产生多个实例，不可用
* */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (null == instance) {
            synchronized (Singleton3.class) {
                instance = new Singleton3();
            }
        }

        return instance;
    }
}
