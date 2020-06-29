package zhaoyang.study.java8.volatileKeyWord;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaoyang
 * @Date 2020/6/27 - 14:25
 */
public class VolatileDemo {
    public static void main(String[] args) {
//        seeOKByVolatile();

        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();   //volatile变量自增
                    myData.addAtomic(); //AtomicInteger引用变量自增
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){   //main线程和gc线程
            Thread.yield(); //礼让其他线程
        }

        System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type, finally number value:" +
                " " + myData.atomicInteger);
    }

    //volatile保证可见性，及时通知其他线程，主内存变量已经被修改
    public static void seeOKByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t comes in");
            try {
                TimeUnit.SECONDS.sleep(3);  //手动延迟3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
        }, "AAA").start();

        while (myData.number == 0){
            //main线程等待myData的number值发生变化
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value: " + myData.number);
    }
}

class MyData{
    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }

    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();  //初始值默认是0
    public void addAtomic(){
        atomicInteger.getAndIncrement();    //获取当前值并加1；
    }
}