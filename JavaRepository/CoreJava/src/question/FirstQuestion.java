package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class FirstQuestion {
    String a = "Helo";
    public static void main(String[] args) {
        // First Question:
        // 在一个静态成员中调用一个非静态成员为什么是非法的？
        // a = "world";

        FirstQuestion firstQuestion = new FirstQuestion();
        firstQuestion.a = "world";

        /*
        * 因为静态方法可以不通过对象进行调用，所以在静态方法里，
        * 不能调用其他非静态变量，也不可以访问非静态变量成员。
        *
        * 其他答案： 在一个类的静态成员中去调用非静态成员之所以会出错是因为：
        * 在类的非静态成员不存在的时候，类的静态成员就已经存在了，访问一个不存在的成员自然会报错（类加载的顺序）
        * */

        // Second Question:
        // 在 Java 中定义一个不做事且没有参数的构造方法的作用?
        /*
        * Java程序在执行子类的构造方法之前，如果没有用super()去显式的调用父类的构造方法，则会自动调用父类的无参构造方法。
        * 因此，如果父类中只定义了带参数的构造方法，而在子类中又没有用super()去调用这个带参数的构造方法的话，会发生编译时
        * 错误。因此Java程序在父类中找不到无参的构造方法可以执行。解决办法就是在父类上加一个无参构造方法。
        * 可参见Person类和Student类
        * */


        //Third Question:
        // import java 和 javax 有什么区别？
        /*
        * 没有区别。 刚开始的时候，JavaAPI所需的包都是Java开头的，javax当时只是扩展API来使用，然而随着时间的推移，javax逐渐地
        * 扩展成为JavaAPI的一部分，但是将javax移植到javaAPI实在太麻烦，会破坏一堆现有的代码，因此决定javax 包将成为标准API的一部分。
        * */

        //Fourth Question:
        // 接口和抽象类的区别？
        /*
        * 1. 接口中的方法默认是Public的,所有方法在接口中不能有实现（在Java8中可以有默认实现）。而抽象类中可以有非抽象的方法。
        * 2. 一个类可以实现多个接口，但只能继承一个类。接口本身可以通过extends关键字来扩展多个接口
        * 3. 从设计层面来说，抽象是对类的抽象，是一种模板设计，而接口是对行为的抽象，是一种行为的规范。
        * 4. 接口方法默认修饰符是public， 抽象方法可以有public, default, protected这些，不能用private来修饰抽象方法
        * 5. 接口中不能有构造方法，而抽象类中可以有.
        *
        *
        * 关于抽象类：
        * JDK1.8之前，抽象类的方法默认访问权限是protected
        * JDK1.8之后，抽象类的默认访问权限是default
        *
        * 关于接口：
        * JDK 1.8以前，接口中的方法必须是public的
        * JDK 1.8时，接口中的方法可以是public的，也可以是default的
        * JDK 1.9时，接口中的方法可以是private的
         * */

        // Fifth Question:
        // 静态方法和实例方法的区别
        /*
        * 1. 调用静态方法时，可以使用'类名.方法名'，也可以使用'对象.方法名'，实例方法只能使用'对象.方法名'
        * 2. 静态方法在访问本类的成员时，只能访问静态成员，不能访问实例成员变量和实例方法。 实例方法则没有这个限制
        * */

        // Sixth Question:
        // 对象的相等与指向他们的引用相等,两者有什么不同?
        /*
        *  对象的相等，比较的是内存中存放的内容是否相等
        *  引用的相等，比较的是他们在内存中的地址是否相等
        * */

        // Seventh Question:
        // == 和 equals 的比较
        /*
        *  == ：它的作用是判断两个对象的内存地址是否一样，即判断两个对象是否是同一个对象(基本数据类型比较的是值，引用数据类型比较的是地址)
        *
        *  equals: 它的作用也是判断两个对象是否相等，但一般有两种情况：
        *           1. 类没有覆盖equals方法，此时equals 等价于 ==
        *           2. 类覆盖了equals方法，一般我们都会覆盖equals来比较两个对象的内容是否相等，若他们的内容相等。则返回true
        *
        * String类中的equals方法是被重写过的，所以用equals方法比较两个字符串比较的是字符串的内容
        *
        * */


        // Eighth Question:
        // hashcode 和 equals：
        /*
        *   博客园收藏文章！  https://www.cnblogs.com/skywang12345/p/3324958.html
        * */


        // Ninth Question:
        // 为什么Java中只有值传递？
        /*
        *  github : https://github.com/Snailclimb/JavaGuide/blob/master/docs/essential-content-for-interview/MostCommonJavaInterviewQuestions/%E7%AC%AC%E4%B8%80%E5%91%A8%EF%BC%882018-8-7%EF%BC%89.md
        * */

        // Tenth Question:
        // 关于 final 关键字的一些总结
        /*
        * final关键字主要用在三个地方：变量、方法、类。
        * 1. 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
        * 2.当用final修饰一个类时，表明这个类不能被继承。final类中的所有成员方法都会被隐式地指定为final方法。
        * 3.使用final方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义；第二个原因是效率。
        *   在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升（现在的Java版本已经不需要使用final方法进行这些优化了）。类中所有的private方法都隐式地指定为final。
        *
        * */

        final A a = new A();
//        a = new A();

        // Eleventh Question:
        // Java序列化中如果有些字段不想进行序列化，怎么办？
        /*
        * 对于不想进行序列化的变量，使用transient关键字修饰。
        *
        * transient关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；
        * 当对象被反序列化时，被transient修饰的变量值不会被持久化和恢复。transient只能修饰变量，不能修饰类和方法。
        * */


        // Twelfth Question:
        // 获取用键盘输入常用的的两种方法
        /*
        * 1. 通过Scanner
        *       Scanner input = new Scanner(System.in);
        *       String s = input.nextLine();
        *       System.out.println(s);
        *       input.close();
        *
        * 2. 通过 BufferedReader
        *         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        *         String s = input.readLine();
        *         System.out.println(s);
         * */


        // Java IO流


        // 常见关键字总结:static,final,this,super
        // https://gitee.com/SnailClimb/JavaGuide/blob/master/docs/java/Basis/final、static、this、super.md


        StaticBean t = new StaticBean("Lewis");
        t.age = 100;
        System.out.println(t.age);
        System.out.println(StaticBean.age);


    }
}

class Person {
    public Person() {

    }
    public Person(String name) {
        System.out.println(name);
    }
}

class Student extends Person {

}

interface TestInterface {
      String a = "10";
//    public TestInterface();
    String test();
    public String test2();
//    private String test3();
}

abstract class TestClass {
    public TestClass() {

    }

    protected abstract void ask();
}


final class A {

}

class StaticBean {

    String name;
    // 静态变量
    static int age;

    public StaticBean(String name) {
        this.name = name;
    }

    // 静态方法
    static void SayHello() {
        System.out.println("Hello i am java");
    }

    // 静态代码块， 存在于类中方法外。 执行顺序： 静态代码块 -> 非静态代码块 -> 构造方法
    // 无论该类创建多少对象，静态代码块只执行一次
    // 一个类中可以有多个静态代码块，JVM会按照它们的顺序依次执行，每个代码块只会被执行一次
    // 静态代码块一般用来给静态变量赋值
    static {
        age = 100;
        System.out.println("static age:" + age);

        // 静态代码块对于定义在它之后的静态变量，可以赋值，但不能访问
        score = 100;
//        System.out.println("static score:" + score);

    }

    // 非静态代码块
    // 非静态代码块，每new一个对象就执行一次，可以在普通方法中定义，不过作用不大
    {
        System.out.println("Non-Static code");
    }

    static int score;

}
