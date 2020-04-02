package zhaoyang.study.concurrent;

import java.util.concurrent.TimeUnit;

class Phone {
    public static synchronized void sendEmail() throws InterruptedException {
//        Thread.sleep(4000); //弊端：单位只能是毫秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("****sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("****sendSMS");
    }

    public void sayHello() {
        System.out.println("***sayHello");
    }
}


/*
8 lock
* 1. 标准访问，先访问邮件还是短信
* 2. 邮件方法暂停4秒，先访问邮件还是短信
* 3. 新增普通方法 sayHello，先访问邮件还是hello
* 4. 两部手机，先访问邮件是短信
* 5. 两个静态同步方法，同一手机先访问邮件还是短信
* 6. 两个静态同步方法，两部手机先访问邮件还是短信
* 7. 一个静态同步方法，一个普通同步方法，同一手机先访问邮件还是短信
* 8. 一个静态同步方法，一个普通同步方法，两部手机先访问邮件还是短信
* */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);  //人为先执行A线程

        new Thread(() -> {
            phone.sendSMS();
//            phone.sayHello();
//            phone2.sendSMS();
        }, "B").start();
    }
}
