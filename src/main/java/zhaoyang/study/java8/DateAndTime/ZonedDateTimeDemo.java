package zhaoyang.study.java8.DateAndTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author zhaoyang
 * @Date 2020/5/16 - 14:37
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args) {

        /*
        * 获取指定时区下的日期时间
        * */
        ZoneId america = ZoneId.of("America/New_York"); //纽约时区
        LocalDateTime localDateTime = LocalDateTime.now();  //当前日期时间
        ZonedDateTime dateTimeInNewYork = ZonedDateTime.of(localDateTime, america);
        System.out.println("当前日期和时间在特定的时区：" + dateTimeInNewYork);
    }
}
