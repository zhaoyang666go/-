package zhaoyang.study.java8.Throwable.Error;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyang
 * @Date 2020/7/8 - 14:12
 *
 * 应用创建线程数超过OS默认上限
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i=1; ; i++){
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  //暂停...s
            }, i+"").start();
        }
    }
}
