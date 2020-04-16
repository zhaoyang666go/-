package zhaoyang.study.java8.ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 复制图片
* 一读一写
* */
public class CopyPictureDemo {
    private static String pathFrom = "G:\\picture\\cat.gif";
    private static String pathTo = "src\\testFiles\\cat.gif";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream(pathFrom);
        FileOutputStream fos = new FileOutputStream(pathTo);

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        //释放资源，先关写流，再关读流
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();
        System.out.println("拷贝文件共耗时：" + (end - start) + "毫秒");
    }
}
