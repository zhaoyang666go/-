package zhaoyang.study.java8.Throwable.Error;

/**
 * @author zhaoyang
 * @Date 2020/7/8 - 9:07
 *
 * SOFE：Stack Over Flow Error
 *  栈溢出
 *  递归模拟栈溢出
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlow();
    }

    private static void stackOverFlow() {
        stackOverFlow();
    }
}
