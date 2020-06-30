package zhaoyang.study.collection.arrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/*
线程安全的Set
* */
public class NotSafeDemo2 {
    public static void main(String[] args) {
        setNotSafe();
    }

    private static void setNotSafe() {
//        Set<String> set = new HashSet<>();  //不安全
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();  //安全

        for (int i=1; i<=30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
