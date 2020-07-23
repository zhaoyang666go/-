package zhaoyang.study.java8.ioStream;

import java.io.*;

/*
* 转换流：编码格式
* */
public class ConversionStreamDemo {
    private static String path = "src\\testFiles\\g.txt";
    private static String path2 = "src\\testFiles\\h.txt";

    public static void main(String[] args) {
//        outputStreamWriter01();

//        outputStreamWriter02();

//        inputStreamReader();

        transformCode();
    }

    /*
    * 转换文件编码
    *   将GBK文本文件，转换为UTF-8文本文件
    * */
    private static void transformCode() {
        try(Reader reader = new InputStreamReader(new FileInputStream(path), "GBK");
            Writer writer = new OutputStreamWriter(new FileOutputStream(path2), "UTF-8")) {

            int len;
            while ((len = reader.read()) != -1) {
                writer.write(len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    * 读GBK文件
    * */
    private static void inputStreamReader() {
        try(Reader reader = new InputStreamReader(new FileInputStream(path), "gbk")) {
            int len;
            while ((len = reader.read()) != -1) {
                System.out.print((char)len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    * 写GBK格式文件
    * */
    private static void outputStreamWriter02() {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(path), "gbk")) {
            writer.write("朝阳");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    * 写UTF-8格式的文件
    * */
    private static void outputStreamWriter01() {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(path), "utf-8")) {  //默认也是UTF-8
            writer.write("你好");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
