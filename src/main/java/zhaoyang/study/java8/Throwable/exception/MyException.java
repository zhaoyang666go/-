package zhaoyang.study.java8.Throwable.exception;

public class MyException extends Exception{
    //无参构造方法
    public MyException(){}

    //带异常信息的构造方法
    public MyException(String message) {
        super(message);
    }
}
