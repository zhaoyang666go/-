package zhaoyang.study.java8.DateAndTime;

import java.time.LocalTime;

/**
 * @author zhaoyang
 * @Date 2020/5/16 - 10:48
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        /*
        * 获取当前时间
        * */
        LocalTime currentTime = LocalTime.now();
        System.out.println("当前时间：" + currentTime);

        LocalTime twoHoursLater = currentTime.plusHours(2);   //当前时间加两小时
        System.out.println("两小时后：" + twoHoursLater);
    }
}
