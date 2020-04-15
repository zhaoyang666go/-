package zhaoyang.study.java8.ioStream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/*
* java.io.FileReader extends InputStreamReader extends Reader
* */
public class ReaderDemo {
    private static String path = "src/testFiles/a.txt";

    public static void main(String[] args) throws IOException {
//        luanma();

//        read01();

        read02();
    }

    private static void read02() throws IOException {
        FileReader fr = new FileReader(path);

        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        fr.close();
    }

    private static void read01() throws IOException {
        FileReader fr = new FileReader(path);

        int len;
        while (((len = fr.read()) != -1)) {
            System.out.print((char)len);
        }

        fr.close();
    }

    private static void luanma() throws IOException {
        FileInputStream fis = new FileInputStream("src/testFiles/a.txt");

        int len;
        while ((len=fis.read()) != -1) {
            System.out.println((char)len);  //乱码
        }

        fis.close();
    }
}
