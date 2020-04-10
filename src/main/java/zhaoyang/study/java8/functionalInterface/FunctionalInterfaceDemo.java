package zhaoyang.study.java8.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
* 函数式接口
* */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = s -> {return s.length();};
        System.out.println(function.apply("zhaoyang"));

        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("zhaoyang"));

        Consumer<String> consumer = s -> {System.out.println(s);};
        consumer.accept("zhaoyang");

        Supplier<String> supplier = () -> {return "zhaoyang";};
        System.out.println(supplier.get());
    }
}