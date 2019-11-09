package keyword;

import javax.xml.soap.SAAJMetaFactory;

public class StringKeyword {
    public static void main(String[] agrs) {
        String a = "hellop world";  // hello world
        String b = new String("Hello");  // Hello
        char[] chArr = {'a', 'b', 'c'};
        String c = new String(chArr); // abc
        System.out.println(c);

        //创建字符串对象两种方式的区别
        String q = "hello"; // 直接赋值创建对象实在方法区的常量池

        String str = new String("hello");  // 通过构造方法创建字符串对象是在堆内存

        // 两种实例化方法的比较
        String str1 = "Lewis";
        String str2 = new String("Lewis");
        String str3 = str2; // 引用传递，str3直接指向st2的堆内存地址
        String str4 = "Lewis";

        /*
         *  == :
         *  基本数据类型比较的是  值是否相同
         *  引用数据类型比较的是  地址值是否相同
         *  String属于引用数据类型
         * */
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str3 == str2);
        System.out.println(str1 == str4);

        String str5 = new String("Jing").intern(); //手动将string放入到常量池
        String str6 = "Jing";
        System.out.println(str5 == str6);

        // == 和 equals 比较字符串的区别
        // == 比较的是字符串的内存地址。  equals比较的是字符串的内容(因为string重写了equals方法)
        // equals()通过接受参数，可以避免空指向。
        String str7 = null;
//        if (str7.equals("hello")) {  //空指针异常
//
//        }

        if ("hello".equals(str7)) {

        }

        // 字符串一旦声明就不可以改变，改变的只是地址，原来的字符串还是存在
        String str8 = "Hello World";
        str8 = "Hello";

        //经典面试题
        a = "abc";
        b = "abc";
        c = new String("abc");
        System.out.println(a == b);  //true
        System.out.println(a.equals(b));  //true
        System.out.println(a == c);  //false
        System.out.println(a.equals(c));  //true

        //在object中，equals()是用来比较内存地址的，但是String重写了equals()方法，用来比较内容的，即使是不同地址，只要内容一致，也会返回true

        String s = new String("hello");
        // 以上代码创建了几个对象？
        // 创建了两个对象。 首先是hello这个字符串对象。 JVM会先从常量池中寻找是否有hello这个字符串，如果没有，就会创建出hello对象
        //  在一个就是这个new 关键字，因为有new，所以JVM会在堆内存中创建出一个对象。

        StringBuffer sb = new StringBuffer("Hello");

        // String StringBuffer StringBuilder的区别

        /*
        * String类由final修饰，所以String是不可变的。它的运行速度最慢
        * StringBuilder因为是线程不安全的，所以它的运行速度是最快的
        * StringBuffer是线程安全的，所以与运行速度介于两者之间
        *
        * StringBuffer和StringBuilder是字符串变量，创建对象之后，一直操作的都是这个对象。
        * String属于字符串常量
        *
        * 对三者的总结：
        * 1. 操作少量的数据：String
        * 2. 单线程下在字符串缓存区操作大量数据： StringBuilder
        * 3. 多线程下在字符串缓存区操作大量数据： StringBuffer
        * */

        //有一种特殊情况，String和StringBuffer的运行速度是差不多的
         String stu = "This is only a" + "simple" + "test";
         StringBuffer buffer = new StringBuffer("This is only a").append("simple").append("test");

         // 上述代码实际上是： String stu = "This is only a simple test".

    }
}
