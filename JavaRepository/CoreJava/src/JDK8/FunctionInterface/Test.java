package JDK8.FunctionInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


/*
* 参考文章： https://blog.csdn.net/u012777670/article/details/82559427
* https://blog.csdn.net/icarusliu/article/details/79495534
* */

public class Test {
    public static void main(String[] args) {
        TestInterface testInterface = () -> System.out.println("This is test interface");
        testInterface.test();

        TestInterface testInterface1 = new TestInterface() {
            @Override
            public void test() {
                System.out.println("This is test2 interface");
            }
        };

        testInterface1.test();

        // 大多数场景中，我们使用函数式编程都是在stream中
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");

        stringList.stream().forEach((value) -> {
            System.out.println(value);
        });

        //以上代码的实质是：
        Consumer<String> stringConsumer = (value) -> {
            System.out.println(value);
        };

        stringList.stream().forEach(stringConsumer);

        // 方法引用，也就是双冒号写法
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);

        int maxInt = list.stream().max(Integer::compareTo).get();
        System.out.println(maxInt);

        List<Integer> list1 = new ArrayList();
        list1.add(-3);
        list1.add(-5);
        list1.add(-2);
        list1.add(-9);
        list1.add(-1);

        list1.stream().map(Math::abs).allMatch(e -> e > 0);

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tony", 23));
        personList.add(new Person("Lewis", 20));

        Person person = personList.stream().min(comparator::compare).get();
//        Person person = personList.stream().min(comparator).get();
        System.out.println(person.getAge());

        Person person1 = Person.createPerson(Person::new);

        //引用方式的话有以下几种

        /*
        * 对象引用::实例方法名
        * 类名:: 静态方法名
        * 类名:: 实例方法名
        * 类名::new
        * */

    }

    public static class Person {
        private String name;
        private Integer age;

        // Supplier是一个函数式接口，用于提供一个对象
        public static Person createPerson(Supplier<Person> supplier) {
            return supplier.get();
        }

        public Person() {
            this.name = "";
            this.age = -1;
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}


// 函数式接口中只能有一个抽象方法
@FunctionalInterface
interface TestInterface {
    void test();
}
