package zhaoyang.study.collection.arrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NotSafeDemo3 {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(); //new HashMap<>();

        for (int i=1; i<=30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
