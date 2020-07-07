package zhaoyang.study.java8.Reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author zhaoyang
 * @Date 2020/7/7 - 15:41
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myhashmap();
        System.out.println("===================");
        myweakhashmap();
    }

    private static void myweakhashmap() {
        WeakHashMap<Integer, String> map = new WeakHashMap();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    private static void myhashmap(){
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
