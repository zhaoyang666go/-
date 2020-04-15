package zhaoyang.study.java8.ioStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
//        write01();

//        write02();
        
//        write03();

//        write04();

        write05();
    }

    /*
    * 换行符
    *   Windows：\r\n
    *   Linux: /n
    *   MAC: /r
    * */
    private static void write05() throws IOException { //换行并续写
        FileOutputStream fos = new FileOutputStream("I:\\study-spring-boot\\src\\testFiles\\f.txt", true);

        for (int i=1; i<=10; i++) {
            fos.write("你好\r\n".getBytes());
        }

        fos.close();
    }

    private static void write04() throws IOException {  //续写，不覆盖
        FileOutputStream fos = new FileOutputStream("I:\\study-spring-boot\\src\\testFiles\\f.txt", true);
        fos.write("你好".getBytes());
        fos.close();
    }

    /*
    * public void write(byte[] b, int off, int len)：把字节数组的一部分写入文件
    *   int off：数组的开始索引
    *   int len：写几个字节
    * */
    private static void write03() throws IOException {
        byte[] bytes = {65, 66, 67, 68, 69};

        FileOutputStream fos = new FileOutputStream("C:\\Users\\86151\\Desktop\\aaa\\e.txt");
        fos.write(bytes, 1, 2);

        byte[] bytes1 = "朝阳".getBytes();    //字符串转换为字节数组
        System.out.println(Arrays.toString(bytes1));
        fos.write(bytes1);

        fos.close();
    }

    private static void write02() throws IOException {  //文件中写入 100
        FileOutputStream fos = new FileOutputStream("C:\\Users\\86151\\Desktop\\aaa\\d.txt");
        fos.write(49);  //一次写一个字节
        fos.write(48);
        fos.write(48);

        /*
        * 一次写多个字节
        *   如果第一个字节是0~127，查询ASCII编码表显示
        *   如果第一个字节是负数，第一个字节和第二个字节组成一个中文显示（GBK）
        * */
//        byte[] bytes = {65, 66, 67, 68, 69};  //ABCDE
        byte[] bytes = {-65, -66, -67, 68, 69}; //烤紻E
        fos.write(bytes);
        fos.close();
    }

    private static void write01() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\86151\\Desktop\\aaa\\c.txt");
        fos.write(97);  //一次写一个字节
        fos.close();
    }
}
