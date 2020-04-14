package zhaoyang.study.java8.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File pathname) {  //过滤逻辑
        Objects.requireNonNull(pathname);   //非空校验

        if (pathname.isDirectory()) {   //目录返回true加入到文件数组中
            return true;
        }

        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}

public class FileFilterDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\86151\\Desktop\\aaa");
        getAllFile(file);
    }

    private static void getAllFile(File dir) {
//        System.out.println(dir);

//        File[] files = dir.listFiles();   //不过滤直接遍历

//        File[] files = dir.listFiles(new FileFilterImpl());   //传递的参数为FileFilter的实现类

        File[] files = dir.listFiles(new FileFilterImpl() { //匿名内部类的参数形式
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt");
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
