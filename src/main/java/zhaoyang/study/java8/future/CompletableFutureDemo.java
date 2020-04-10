package zhaoyang.study.java8.future;

import java.util.concurrent.CompletableFuture;

/*
* 异步调用
* */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {

        //无返回值
        CompletableFuture<Void> completableFuture01 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 无返回值，不妨碍主线程");
        });
        completableFuture01.get();

        //有返回值
        CompletableFuture<Integer> completableFuture02 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 有返回");
            int age = 10/0;
            return 1024;
        });
        completableFuture02.whenComplete((t, u) -> {    //正常完成
            System.out.println("*********ttt\t" + t);   //返回值
            System.out.println("*********uuu\t" + u);   //异常
        }).exceptionally(f -> { //异常出事
            System.out.println("******exception:\t" + f.getMessage()); //异常信息
            return 444;
        }).get();
    }
}
