package zhaoyang.study.collection.arrayList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
* 线程不安全 case
*
* 故障现象
*   java.util.ConcurrentModificationException （并发修改异常）
* 导致原因
*   多线程争抢未加锁资源
* 解决方案
*   1. new Vector()：add方法加锁，保证数据一致性，但并发性下降
*   2. Collections.synchronizedList(new ArrayList<>())：集合辅助工具类将某个不安全的类包装为安全的类
*   3. new CopyOnWriteArrayList()
* 优化建议（同样的错误不犯第二次）
*   使用Java工具包的并发工具类
* */
public class NotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();

//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.forEach(System.out::println);

        for (int i=1; i<=30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8)); //写
                System.out.println(list);   //读
            }, String.valueOf(i)).start();
        }

    }
}
