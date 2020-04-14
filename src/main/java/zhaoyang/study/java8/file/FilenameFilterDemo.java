package zhaoyang.study.java8.file;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\86151\\Desktop\\aaa");
        getAllFile(file);
    }

    private static void getAllFile(File dir) {
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".txt");
//            }
//        });

//        File[] files = dir.listFiles((File parent, String child) -> {   //Lambda表达式
//            return new File(parent, child).isDirectory() || child.toLowerCase().endsWith(".txt");
//        });

        File[] files =
                dir.listFiles((parent, child) -> new File(parent, child).isDirectory() || child.toLowerCase().endsWith(".txt"));

        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
