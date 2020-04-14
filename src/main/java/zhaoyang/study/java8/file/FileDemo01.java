package zhaoyang.study.java8.file;

import java.io.File;

/*
* File类构造方法
* */
public class FileDemo01 {
    public static void main(String[] args) {
        show01();
        show02("C:\\", "a.txt");
        show03();
    }

    private static void show03() {
        File parent = new File("C:\\");
        File file = new File(parent, "file.java");
        System.out.println(file);
    }

    private static void show02(String parent, String child) {
        File f = new File(parent, child);
        System.out.println(f);
    }

    private static void show01(){
        File f1 = new File("C:\\Users\\86151\\Desktop\\a.txt");
        System.out.println(f1);   //File重写了Object的toStirng方法

        File f2 = new File("b.txt");    //相对于当前项目路径
        System.out.println(f2);
    }
}
