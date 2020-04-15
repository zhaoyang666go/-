package zhaoyang.study.java8.ioStream;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo {
    private static String path = "src\\testFiles\\f.txt";

    public static void main(String[] args) throws IOException {
//        read01();

        read02();
    }


    /*
    * int read(byte[] b)
    *   从输入流读取一定数量的字节，存储在缓冲区数组中
    *   byte[] b：起缓冲作用，存储每次读取到的多个字节，长度一般是1024及其整数倍
    *   int类型的返回值：每次读取的有效个数，到头返回-1
    * */
    private static void read02() throws IOException {
        FileInputStream fis = new FileInputStream(path);

        byte[] bytes = new byte[1024];
        int len = 0;    //每次读取字节个数
        while (-1 != (len = fis.read(bytes))) {
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
    }

    /*
    * int read()
    *   读取文件中一个字节并返回
    *   指针后移
    *   读取文件末尾返回-1
    * */
    private static void read01() throws IOException {
        FileInputStream fis = new FileInputStream(path);

        /*
        * 不知道文件中有多少字节，使用while循环
        * 循环结束条件，返回-1
        * */
        int result;
        while (-1 != (result = fis.read())) {
            System.out.println(result);
        }

        fis.close();
    }
}
