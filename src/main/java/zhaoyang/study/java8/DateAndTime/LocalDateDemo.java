package zhaoyang.study.java8.DateAndTime;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author zhaoyang
 * @Date 2020/5/16 - 10:11
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        getCurrentDate();   //今天日期
        System.out.println("------");
        getDetailDate();    //今天日期的年、月、日
        System.out.println("------");
        handleSpecialDate(2018, 9, 1);  //指定日期
        System.out.println("------");

        /*
        * 判断两个日期是否相同
        * */
        LocalDate today = LocalDate.now();
        LocalDate schoolDay = LocalDate.of(2018, 9, 1);
        System.out.println(today.equals(schoolDay));
        LocalDate copyToday = LocalDate.now();
        System.out.println(today.equals(copyToday));

        /*
        * 处理周期性日期
        * */
        LocalDate today02 = LocalDate.now();    //今天
        LocalDate birthDate = LocalDate.of(2018, 9, 1); //出生日期

        MonthDay birthday = MonthDay.of(birthDate.getMonth(), birthDate.getDayOfMonth());   //生日月日
        MonthDay currentMonthDay = MonthDay.from(today02);  //今天月日

        if (currentMonthDay.equals(birthday)) {
            System.out.println("生日快乐");
        } else {
            System.out.println("今天不过生日");
        }
        System.out.println("------");

        /*
        * 信用卡到期等固定日期
        * */
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2021, Month.JUNE);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        System.out.println("------");

        /*
        * 计算一周后的日期
        * ChronoUnit：计时装置
        * */
        LocalDate today03 = LocalDate.now();
        LocalDate nextWeek = today03.plus(1, ChronoUnit.WEEKS);
        System.out.println("今天是：" + today03);
        System.out.println("一周后是：" + nextWeek);
        System.out.println("------");

        /*
        * 计算一年前或一年后的日期
        * */
        LocalDate today04 = LocalDate.now();
        LocalDate nextYear = today04.plus(1, ChronoUnit.YEARS);
        LocalDate previousYear = today04.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前：" + previousYear);
        System.out.println("一年后：" + nextYear);
        System.out.println("------");

        /*
        * 比较两个日期的早晚
        * */
        LocalDate today05 = LocalDate.now();
        LocalDate tomorrow = today05.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = today05.minus(1, ChronoUnit.DAYS);

        if (tomorrow.isAfter(today05)) {
            System.out.println("明天在今天后边");
        }
        if (yesterday.isBefore(today05)) {
            System.out.println("昨天在今天前边");
        }
        System.out.println("------");

        /*
        * 闰年
        * */
        LocalDate today07 = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("今年是闰年");
        } else {
            System.out.println("今年不是闰年");
        }
        System.out.println("------");

        /*
        * 两个日期之间的天数、月数
        * 年份相差、月份相差、天数相差分别计算
        * */
        LocalDate today08 = LocalDate.now();
        LocalDate randomDay = LocalDate.of(2022, Month.JUNE, 12);
        Period days = Period.between(today08, randomDay);
        System.out.println("两个日期间月份相差：" + days.getMonths());
        System.out.println("两个日期天数相差几天：" + days.getDays());
        System.out.println("------");

        /*
        * 包含时差信息的日期时间
        * */
        LocalDateTime specialDateTime = LocalDateTime.of(2020, Month.MAY, 16, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(specialDateTime, offset);
        System.out.println(date);
        System.out.println("------");

        /*
        * 格式化工具
        * */
        String datetimeStr = "20200516";
        LocalDate formatted = LocalDate.parse(datetimeStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(formatted);
    }

    private static void handleSpecialDate(int year, int month, int day) {   //通过参数创建任意日期
        LocalDate specialDate = LocalDate.of(year, month, day);
        System.out.println("指定日期：" + specialDate);
    }

    private static void getDetailDate() {   //分别获取日期的年、月、日
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.printf("Year: %d, Month: %d, Day: %dt", year, month, day);
        System.out.println();
    }

    private static void getCurrentDate() {  //获取今天日期
        LocalDate today = LocalDate.now();  //不含时间，格式友好
        System.out.println("Today is : " + today);

        Date date = new Date();
        System.out.println(date);
    }
}
