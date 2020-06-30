package zhaoyang.study.java8.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*
* ArrayBlockingQueue：由数组结构组成的有界阻塞队列
* */

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        addAndRemove();
//        offerAndPoll();
//        putAndTake();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x", 3L, TimeUnit.SECONDS)); //过时不候

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));   //过时不候
    }

    private static void putAndTake() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /*
        * 如果队列已满线程等待，直到队尾空出来再增添元素
        * */
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("x");

        /*
        * 如果队列为空，无队首元素，线程等待，直到出现队首元素再获取
        * */
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
    }

    private static void offerAndPoll() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /*
        * 效果同add方法
        * 队列满时再添加数据不报异常，返回boolean类型的添加失败结果false
        * */
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void addAndRemove() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //可添加相同的元素，因为底层是数组
        System.out.println(blockingQueue.add("a")); //add方法返回boolean类型的值
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x")); //队列已满再添加元素抛出异常：IllegalStateException：Queue full

        System.out.println(blockingQueue.element());    //获取队首元素，队列为空抛异常

        System.out.println(blockingQueue.remove()); //remove方法返回移除的元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); //队列已空抛出异常：NoSuchElementException
    }
}
