package zhaoyang.study.jvm;

public class MyObject {
    public static void main(String[] args) {
        Object obj = new Object();  //系统自带的类
//        System.out.println(obj.getClass().getClassLoader().getParent().getParent());    //异常
//        System.out.println(obj.getClass().getClassLoader().getParent());    //异常
        System.out.println(obj.getClass().getClassLoader());    //null  启动类加载器(Bootstrap)

        System.out.println("***************");

        MyObject myObj = new MyObject();
        System.out.println(myObj.getClass().getClassLoader().getParent().getParent());  //null
        System.out.println(myObj.getClass().getClassLoader().getParent());  //ExtClassLoader    扩展类加载器
        System.out.println(myObj.getClass().getClassLoader());  //AppClassLoader 应用程序类加载器

        Thread thread = new Thread();
        thread.start();
    }
}
