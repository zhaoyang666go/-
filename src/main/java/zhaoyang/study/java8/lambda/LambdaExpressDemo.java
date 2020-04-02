package zhaoyang.study.java8.lambda;

@FunctionalInterface    //标识函数式接口，接口内只能有一个方法
interface Foo {
//    void sayHello();
    int add(int x, int y);

    /*
    * default 关键字标识的方法可以在函数式接口中多次出现
    * 打破 Java 中接口不能有方法体的桎梏
    * */
    default int mul(int x, int y){
        return x * y;
    }

    default int mul2(int x, int y){
        return x * y;
    }

    /*
    * 静态方法也可定义多个
    * */
    static int div(int x, int y) {
        return x / y;
    }

    static int div2(int x, int y) {
        return x / y;
    }
}

/*
* 无参无反：拷贝小括号，写死右箭头，落地大括号
*
* */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello lambda");
            }
        };
        foo.sayHello();*/

        /*Foo foo = () -> {
            System.out.println("hello lambda");
        };*/

        Foo foo = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };


        System.out.println(Foo.div(4, 2));  //static
        System.out.println(foo.add(1, 2));
        System.out.println(foo.mul(1, 2));  //default
        System.out.println(foo.mul2(3, 4)); //default
//        foo.sayHello();
    }
}
