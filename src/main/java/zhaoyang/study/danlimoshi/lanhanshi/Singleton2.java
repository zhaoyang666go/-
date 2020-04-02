package zhaoyang.study.danlimoshi.lanhanshi;

/*
* 示例2
* 同步方法，线程安全，效率低，不推荐
* */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2 () {}

    public static synchronized Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }

        return instance;
    }
}
