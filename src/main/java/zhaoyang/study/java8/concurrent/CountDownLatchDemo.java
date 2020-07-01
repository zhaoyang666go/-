package zhaoyang.study.java8.concurrent;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/*
* 问题1：
*   七个人晚自习（值日生和六个学员）
*   等学员都回去休息了，值日生关灯锁门
*
* 问题2：
*   秦灭六国，统一华夏
* */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        closeDoor();
//        closeDoorCountDownLatch();

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=1; i<=6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭!");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 大秦一统华夏！！！");
    }

    /*使用CountDownLatch解决问题*/
    private static void closeDoorCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);  //倒计时计数器，构造参数传“数几个数”

        for(int i=1; i<=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开自习室");
                countDownLatch.countDown(); //减1
            }, String.valueOf(i)).start();
        }

        countDownLatch.await(); //计数器为0才能往下执行
        System.out.println(Thread.currentThread().getName() + "\t 值日生关灯锁门，离开自习室");
    }

    /*问题1失败Case*/
    private static void closeDoor() {
        for(int i=1; i<=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开自习室");
            }, String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName() + "\t 关灯锁门，离开自习室");
    }
}

enum CountryEnum{
    ONE(1, "齐"),
    TOW(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "韩"),
    SIX(6, "魏");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage){
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] countryArray = CountryEnum.values();
        for(CountryEnum country : countryArray){
            if (index == country.getRetCode()){
                return country;
            }
        }

        return null;
    }
}