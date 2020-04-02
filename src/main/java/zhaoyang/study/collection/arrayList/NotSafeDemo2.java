package zhaoyang.study.collection.arrayList;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotSafeDemo2 {
    public static void main(String[] args) {
        setNotSafe();
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>(); //new HashSet<>();

        for (int i=1; i<=30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
