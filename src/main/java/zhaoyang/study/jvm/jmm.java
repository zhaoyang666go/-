package zhaoyang.study.jvm;

class MyNumber {
//    int number = 10;
    volatile int number = 10;

    public void addTo1025(){
        this.number = 1025;
    }
}

public class jmm {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        new Thread(() -> {
            System.out.println("****come in");
            try {
                Thread.sleep(3000); //暂停一会儿线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.addTo1025();
            System.out.println(Thread.currentThread().getName() + "\t update number, number value: " + myNumber.number);
        }, "A").start();

        while (10 == myNumber.number) {
            //需要有一种通知机制告诉 main 线程，number 已经被修改了，跳出循环
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
