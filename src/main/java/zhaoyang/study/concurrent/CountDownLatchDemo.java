package zhaoyang.study.concurrent;

import java.util.concurrent.CountDownLatch;

/*
* 问题：
*   七个人晚自习（值日生和六个学员）
*   等学员都回去休息了，值日生关灯锁门
* */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);  //倒计时计数器，构造参数传“数几个数”

        for(int i=1; i<=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开自习室");
                countDownLatch.countDown(); //减1
            }, String.valueOf(i)).start();
        }

        countDownLatch.await(); //计数器为0才能往下执行
        System.out.println(Thread.currentThread().getName() + "\t 关灯锁门，离开自习室");
    }

    /*
    * 失败Case
    * */
    private static void closeDoor() {
        for(int i=1; i<=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开自习室");
            }, String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName() + "\t 关灯锁门，离开自习室");
    }
}
