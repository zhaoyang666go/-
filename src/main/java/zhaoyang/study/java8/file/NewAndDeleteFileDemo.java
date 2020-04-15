package zhaoyang.study.java8.file;

import java.io.File;
import java.io.IOException;

public class NewAndDeleteFileDemo {
    public static void main(String[] args) throws IOException {
//        createNewFile();

//        mkdir();

        deleteFileOrDirector();
    }

    private static void deleteFileOrDirector() {
        File file = new File("C:\\Users\\86151\\Desktop\\aaa");
        System.out.println(file.delete());
    }

    private static void mkdir() {
        File file = new File("C:\\Users\\86151\\Desktop\\zhaoyang");
        boolean result = file.mkdir();
        System.out.println(result);

        File file1 = new File("C:\\Users\\86151\\Desktop\\aaa\\bbb\\ccc");
        boolean result1 = file1.mkdirs();
        System.out.println(result1);
    }

    private static void createNewFile() throws IOException {
        File file = new File("C:\\Users\\86151\\Desktop\\b.txt");
        boolean result = file.createNewFile();
        System.out.println(result);
    }
}
