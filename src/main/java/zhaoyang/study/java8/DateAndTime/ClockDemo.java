package zhaoyang.study.java8.DateAndTime;

import java.time.Clock;

/**
 * @author zhaoyang
 * @Date 2020/5/16 - 10:58
 */
/*
* Clock：Java8定义的获取时间戳或当前时区下日期时间的类
* */
public class ClockDemo {
    public static void main(String[] args) {
        /*
        * 根据系统时间获取当前时间并设置为UTC
        * */
        Clock clock = Clock.systemUTC();
        System.out.println("Clock: " + clock);

        /*
        * 根据系统的时钟区域获取时间
        * */
        Clock clock02 = Clock.systemDefaultZone();
        System.out.println("Clock：" + clock02);
    }
}
