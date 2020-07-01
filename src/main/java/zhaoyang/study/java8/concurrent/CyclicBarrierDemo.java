package zhaoyang.study.java8.concurrent;

import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
* CyclicBarrier 跟 CountDownLatch 正相反
* Case1：7个人开会，人都到期了才开始
* Case2：集齐7颗龙珠，召唤神龙
* */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
//        meeting();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Thread(() -> {
            System.out.println("*******召唤神龙");
        }));

        for(int i=1; i<=7; i++){
            final int temp = i;
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);   //300ms的寻找时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 收集到" + temp + "星球");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, NPCEnum.forEach_NPCEnum(i).getRetMessage()).start();
        }
    }

    /*集齐7人开会*/
    private static void meeting() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("人到齐了，开会！");
        });

        for (int i=1; i<=7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 到!");

                try {
                    cyclicBarrier.await();  //人没到齐就等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

enum NPCEnum{
    ONE(1, "悟空"),
    TWO(2, "克林"),
    THREE(3, "悟饭"),
    FOUR(4, "特南克斯"),
    FIVE(5, "比克"),
    SIX(6, "悟天"),
    SEVEN(7, "贝吉塔");

    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    NPCEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static NPCEnum forEach_NPCEnum(int index){
        NPCEnum[] npcArray = NPCEnum.values();
        for(NPCEnum npc : npcArray){
            if (index == npc.getRetCode()){
                return npc;
            }
        }
        return null;
    }
}