package zhaoyang.study.java8.volatileKeyWord;

/**
 * @author zhaoyang
 * @Date 2020/6/29 - 9:14
 * desc: 单例模式 DCL+volatile 代码
 */
public class SingletonDemo02 {
    //该单例类的实例对象
    private static volatile SingletonDemo02 instance = null;

    //私有构造方法
    private SingletonDemo02(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法");
    }

    //获取单例类的实例——静态方法
    private static SingletonDemo02 getInstance(){
        if (instance == null){
            synchronized (SingletonDemo02.class){
                if (instance == null){
                    instance = new SingletonDemo02();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        //单线程情况下普通单例模式写法没错
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        System.out.println("===================================");

        //并发多线程后，普通单例模式写法不合适
        for(int i=1; i<=10; i++){
            new Thread(() -> {
                SingletonDemo02.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
