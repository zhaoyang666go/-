package zhaoyang.study.danlimoshi.ehanshi;

public class Singleton5 {
    private static Singleton5 instance = null;

    static {
        instance = new Singleton5();
    }

    private Singleton5() {}

    public static Singleton5 getInstance() {
        return instance;
    }
}
