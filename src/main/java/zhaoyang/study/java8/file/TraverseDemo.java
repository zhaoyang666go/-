package zhaoyang.study.java8.file;

import java.io.File;

/*
* 遍历目录（文件夹）
* */
public class TraverseDemo {
    public static void main(String[] args) {
//        traverse();

        File file = new File("C:\\Users\\86151\\Desktop\\aaa");
        traverseRecursive(file);
    }

    private static void traverseRecursive(File file) {   //递归遍历目录
        System.out.println(file);
        File[] files = file.listFiles();

        for (File file2 : files) {
            if (file2.isDirectory()) {
                traverseRecursive(file2);
            } else {
                System.out.println(file2);
            }
        }
    }

    private static void traverse() {
        File file = new File("C:\\Users\\86151\\Desktop\\aaa");

        String[] filesStr = file.list();
        for (String fileStr : filesStr) {
            System.out.println(fileStr);
        }

        File[] filesFile = file.listFiles();
        for (File fileFile : filesFile) {
            System.out.println(fileFile);
        }
    }
}
