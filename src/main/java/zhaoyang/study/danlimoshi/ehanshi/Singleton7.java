package zhaoyang.study.danlimoshi.ehanshi;

/*
* 静态内部类，线程安全，主动调用时才实例化，延迟加载效率高，推荐
* */
public class Singleton7 {
    private static class SingletonHolder {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    private Singleton7() {}

    public static Singleton7 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
