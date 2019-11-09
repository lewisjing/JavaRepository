package keyword;

public class finalKeyword {
    public static void main(String[] args) {
//        final int a;
//        a = 11;

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;

        System.out.println(a == e);  //false
        System.out.println(a == c);  //true

        // 上述代码： 当final变量是基本数据类型以及String类型的时候，如果在编译期间就能知道他的确切值，那么编译器就会当作常量来使用。
        // 所以，b对于编译器来说就是常量，而对d的访问却要在运行时通过链接来访问。
        // 要注意的是，只有在编译期间能够确切知道final变量的值，才会进行这样的优化。
        // 下面的例子就不会进行优化

        final String f = getHello();
        c = f + 2;
        System.out.println(a == c); // false

        // 被final修饰的引用类型指向的对象内容是否可变？
        MyClass myClass = new MyClass();
        System.out.println(++myClass.i);  // 1
        // 引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的

        // final 和 static
        // static 作用于成员变量只保存一个副本
        // final 作用于保证变量不可变

        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.x);
        System.out.println(myClass1.y);
        System.out.println(myClass2.x);
        System.out.println(myClass2.y);

        // 打印出来的y值都是一样的，而x值却不一样

        myClass.changeValue(10);
        StringBuffer buffer = new StringBuffer("hello ");
        myClass.changeValue2(buffer);
        System.out.println(buffer.toString());
    }

    public static String getHello() {
        return "hello";
    }
}

// final类中的所有成员方法也会被隐式的指定为final方法
final class Student {
    String name;

    String sex;

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String read() {
        System.out.println("read");
        return "read";
    }
}

class Teacher {
    // 当final 作用于类的成员变量时，必须在定义或者在构造器中初始化。一旦被初始化之后，就不能在被赋值了。
    private final String name;

    Teacher(String name) {
        this.name = name;
    }
}

final class MyClass {
    public int i = 0;

    public final double x = Math.random();
    public static double y = Math.random();

    void changeValue (final int i) {
//        i++;
        System.out.println(i);
    }

    void changeValue2 (final StringBuffer buffer) {
        buffer.append("world");
    }
}