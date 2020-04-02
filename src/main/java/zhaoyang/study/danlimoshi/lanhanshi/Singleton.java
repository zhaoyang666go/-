package zhaoyang.study.danlimoshi.lanhanshi;

/*
* 懒汉式
* 类加载的时候创建实例
* */

/*
* 示例1
* 线程不安全，不可用
* */
public class Singleton {
    private static Singleton instance;

    private Singleton () {}

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }

        return instance;
    }
}
