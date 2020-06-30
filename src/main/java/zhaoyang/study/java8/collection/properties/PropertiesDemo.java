package zhaoyang.study.java8.collection.properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    private static String path01 = "src\\testFiles\\prop.txt";

    public static void main(String[] args) throws IOException {
//        show01();

//        store();

        load();
    }

    private static void load() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(path01));
        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            System.out.println(key + ": " + prop.getProperty(key));
        }
    }

    private static void store() {
        Properties prop = new Properties();

        prop.setProperty("张三", "129");
        prop.setProperty("李四", "r43");
        prop.setProperty("王五", "lklre434");

        try(FileWriter fw = new FileWriter(path01)) {
            prop.store(fw, "save txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    * 基本使用
    * Object setProperty(String str1, String str2)
    * Set<String> stringPropertyNames()
    * String getProperty(String key)
    * */
    private static void show01() {
        Properties prop = new Properties();

        prop.setProperty("张三", "129");  //setProperty(String str1, String str2) 集合添加数据
        prop.setProperty("李四", "r43");
        prop.setProperty("王五", "fsfdsf");

        Set<String> set = prop.stringPropertyNames(); //获取集合中的key，存储到Set集合
        for (String str : set) {
            System.out.println(str + ": " + prop.getProperty(str));
        }
    }
}
