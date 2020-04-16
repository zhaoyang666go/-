package zhaoyang.study.java8.ioStream;

import java.io.FileWriter;
import java.io.IOException;

public class TryCatchDemo {
    private static String path = "src\\testFiles\\c.txt";

    public static void main(String[] args) throws IOException {
//        tryCatch01();
        
//        tryCatch02();

//        tryCatch03();
    }

    /*
    * JDK9新特性
    * try之前可以定义流对象
    * try后边()内直接引入流对象
    * try代码执行完毕，自动释放资源，不需要finally释放
    * */
    /*private static void tryCatch03() throws IOException {
        FileWriter fw = new FileWriter(path, true);
        try(fw) {   //JDK8不支持，抛异常
            for (int i=1; i<=5; i++) {
                fw.write("深深的水，静静的流" + i + "\r\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }*/

    /*
    * JDK7新特性
    * try后边()内定义流对象
    * 该流对象仅在try内有效
    * try内代码执行完毕，自动释放资源，不用finally释放
    * */
    private static void tryCatch02() {
        try(FileWriter fw = new FileWriter(path, true)) {
            for (int i=1; i<=10; i++) {
                fw.write("朝阳" + i + "\r\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    //JDK7之前
    private static void tryCatch01() {
        FileWriter fw = null;

        try {
            fw = new FileWriter(path, true);

            for (int i=1; i<=5; i++) {
                fw.write("hello ioStream" + i + "\r\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
