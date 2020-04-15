package zhaoyang.study.java8.ioStream;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    private static String path = "src\\testFiles\\b.txt";

    public static void main(String[] args) throws IOException {
//        write01();

//        write02();

        write03();
    }

    //写字符串
    private static void write03() throws IOException {
        FileWriter fw = new FileWriter(path, true);

        fw.write("\r\n666啊");
        fw.write("\r\n888啊", 2, 3);

        fw.close();
    }

    //写字符数组
    private static void write02() throws IOException {
        FileWriter fw = new FileWriter(path, true);

        char[] chars = {'朝', '阳'};
        fw.write(chars);
        char[] chars2 = {'a', 'b', 'c', 'd', 'e'};
        fw.write(chars2, 1, 3);  //bcd

        fw.close();
    }

    //写单个字符
    private static void write01() throws IOException {
        FileWriter fw = new FileWriter(path);

        char c = '你';
        fw.write(c);
        c = '好';
        fw.write(c);    //不会立马写入

        fw.close(); //先flush再释放资源
    }
}
