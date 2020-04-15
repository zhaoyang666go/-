package zhaoyang.study.java8.ioStream;

import java.io.*;

public class BufferedStreamDemo {
    private static String path = "src\\testFiles\\d.txt";
    private static String path2 = "src\\testFiles\\e.txt";

    public static void main(String[] args) {
//        bufferedOutputStream();
        
//        bufferedInputStream01();

//        bufferedInputStream02();
        
//        bufferedWriter();
        
//        bufferedReader01();
        
//        bufferedReader02();
        
        bufferedReader03();
    }

    private static void bufferedReader03() {
        try(BufferedReader br = new BufferedReader(new FileReader(path2))) {
            String str;
            while ((str = br.readLine()) != null) { //一次读一行
                System.out.println(str);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    private static void bufferedReader02() {
        try(BufferedReader br = new BufferedReader(new FileReader(path2))) {
            char[] chars = new char[1024];
            int len;
            while ((len = br.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    private static void bufferedReader01() {
        try(BufferedReader br = new BufferedReader(new FileReader(path2))) {
            int len;
            while ((len = br.read()) != -1) {
                System.out.print((char)len);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    private static void bufferedWriter() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
            for (int i=1; i<=10; i++) {
                bw.write("朝阳");
                bw.newLine();   //换行
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void bufferedInputStream02() {
        try(InputStream in = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(in)) {

            byte[] bytes = new byte[1024];
            int len;    //每次读取的字节个数
            while ((len = bis.read(bytes)) != -1) { //读取的内容加入到自定的字节数组中
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void bufferedInputStream01() {
        try(InputStream in = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(in)) {

            int len;    //每次读取的字节
            while ((len = bis.read()) != -1) {
                System.out.println(len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void bufferedOutputStream() {
        String str = "zhaoyang666go";

        try(OutputStream out = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(out)) {

            bos.write(str.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
