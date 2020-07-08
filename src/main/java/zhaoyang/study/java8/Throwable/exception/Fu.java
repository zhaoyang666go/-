package zhaoyang.study.java8.Throwable.exception;

/*
* 子父类异常
*   如果父类抛出多个异常，子类重写父类方法时，抛出和父类相同的异常或父类异常的子类或不抛
*   父类方法没有抛异常，子类重写该方法时也不可抛出异常，子类产出该异常，只能捕获处理
* 父类异常什么样，子类异常就什么样
* */
public class Fu {
    public void show01() throws NullPointerException, ClassCastException {}
    public void show02() throws IndexOutOfBoundsException {}
    public void show03() throws IndexOutOfBoundsException {}
    public void show04() {}
}

class Zi extends Fu {
    //子类重写父类方法时，抛出和父类相同的异常
    @Override
    public void show01() throws NullPointerException, ClassCastException {
        super.show01();
    }

    //子类重写父类方法时，抛出父类异常的子类
    @Override
    public void show02() throws ArrayIndexOutOfBoundsException {
        super.show02();
    }

    //子类重写父类方法时，不抛出异常
    @Override
    public void show03() {
        super.show03();
    }

    //父类没有抛出异常，子类也不能抛，只能捕获处理
    @Override
    public void show04() {
//        super.show04();
        try {
            throw new  Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
