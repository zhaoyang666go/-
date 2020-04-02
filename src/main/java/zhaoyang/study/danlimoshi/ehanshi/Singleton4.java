package zhaoyang.study.danlimoshi.ehanshi;

/*
* 饿汉式
* 无线程安全问题，不能延迟加载，影响系统性能
* */

public class Singleton4 {
    private static Singleton4 instance = new Singleton4();

    private Singleton4() {}

    public static Singleton4 getInstance() {
        return instance;
    }
}
