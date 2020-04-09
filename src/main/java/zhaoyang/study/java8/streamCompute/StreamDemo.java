package zhaoyang.study.java8.streamCompute;

/*
* 流式计算
* */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String username;
    private int age;
}

/*
* 题目：按照给出的数据，找出同时满足所有条件的用户
*   偶数id
*   年龄大于24
*   用户名转为大写
*   按用户名字母倒序排列
*   只输出第一个用户的名字
* */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream()
                .filter(u -> {return u.getId() % 2 == 0;})
                .filter(u -> {return u.getAge() > 24;})
                .map(u -> {return u.getUsername().toUpperCase();})
                .sorted((o1, o2) -> {return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
