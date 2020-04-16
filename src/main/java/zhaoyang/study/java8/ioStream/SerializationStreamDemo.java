package zhaoyang.study.java8.ioStream;

import org.springframework.security.core.parameters.P;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* 序列化流
* */
public class SerializationStreamDemo {
    private static String path = "src\\testFiles\\person.txt";
    private static String path2 = "src\\testFiles\\people.txt";

    public static void main(String[] args) {
//        serializablePerson();

//        deserializablePerson();
        
        serializableCollection();
    }

    private static void serializableCollection() {
        Person p1 = new Person("张三", 10);
        Person p2 = new Person("李四", 32);
        Person p3 = new Person("王五", 43);

        List<Person> people = new ArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        List<Person> people2 = null;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path2));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path2))) {
            oos.writeObject(people);
            people2 = (List<Person>) ois.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Person person : people2) {
            System.out.println(person);
        }
    }

    private static void deserializablePerson() {
        Person person = null;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            person = (Person) in.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(person);
    }

    private static void serializablePerson() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(new Person("朝阳", 26));  //子类特有方法，无法使用多态
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
