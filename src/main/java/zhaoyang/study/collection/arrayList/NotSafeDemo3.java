package zhaoyang.study.collection.arrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
* 线程安全的Map
* */
public class NotSafeDemo3 {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i=1; i<=30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
