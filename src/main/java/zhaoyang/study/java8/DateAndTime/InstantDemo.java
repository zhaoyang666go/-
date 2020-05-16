package zhaoyang.study.java8.DateAndTime;

import java.time.Instant;

/**
 * @author zhaoyang
 * @Date 2020/5/16 - 15:10
 */
public class InstantDemo {
    public static void main(String[] args) {
        /*
        * 获取当前时间戳
        * */
        Instant timestamp = Instant.now();
        System.out.println(timestamp);
    }
}
