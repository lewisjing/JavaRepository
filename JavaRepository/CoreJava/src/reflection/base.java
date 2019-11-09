package reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class base {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 在程序运行期间，一个类无论有多少实例，都只有一个class对象产生

        Student stu = new Student();
        // 第一种获取class对象的方式
        Class stuClass = stu.getClass();
        System.out.println(stuClass.getName());  // 获取类的名字

        // 第二种获取class对象的方式
        Class StuClass2 = Student.class;
        System.out.println(StuClass2.getName());
        System.out.println(stuClass == StuClass2); // 判断第一种方式获取的和第二种方式获取的是否是同一个

        //第三种方式获取class对象
        try {
            Class StuClass3 = Class.forName("reflection.Student"); //此字符串必须是真实的路径
            System.out.println(StuClass2 == StuClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 通过反射获取构造方法

        //获取所有public的构造方法
        Constructor[] pubConstructors = stuClass.getConstructors();
        System.out.println("获取所有public的构造方法");
        for (Constructor i: pubConstructors) {
            System.out.println(i);
        }

        //获取所有的构造方法(无论公有私有)
        Constructor[] allConstructors = stuClass.getDeclaredConstructors();
        System.out.println("获取所有的构造方法(无论公有私有)");
        for (Constructor i: allConstructors) {
            System.out.println(i);
        }

        //获取公有，无参的构造方法
        try {
            System.out.println("获取公有，无参的构造方法" );
            Constructor con = stuClass.getConstructor(null);  //因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            System.out.println(con);
            // 调用构造方法
            Object obj = con.newInstance();

            //获取私有构造方法，并调用
            Constructor priCon = stuClass.getDeclaredConstructor(int.class);
            priCon.setAccessible(true);//暴力访问(忽略掉访问修饰符)
            Object priObj = priCon.newInstance(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取成员变量并调用

        //获取所有的public字段
        Field[] pubFields = stuClass.getFields();
        System.out.println("获取所有的public字段");
        for (Field f: pubFields) {
            System.out.println(f);
        }

        //获取所有字段
        Field[] allFields = stuClass.getDeclaredFields();
        System.out.println("获取所有字段");
        for (Field f: allFields) {
            System.out.println(f);
        }

        try {
            //获取单个字段并调用
            Field field = stuClass.getField("name");
            System.out.println("获取单个字段并调用");
            System.out.println(field);
            //创建对象
            Object obj = stuClass.getConstructor().newInstance();
            //赋值
            field.set(obj, "lewis");
            Student stuObj = (Student)obj;
            System.out.println(stuObj.getName());

            // 获取私有字段并调用
            Field priField = stuClass.getDeclaredField("phoneNum");
            System.out.println("获取私有字段并调用");
            System.out.println(field);
            priField.setAccessible(true);
            priField.set(obj, "123456");
            System.out.println(stuObj.getPhoneNum());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取成员方法并调用

        //获取所有public方法
        Method[] pubMethods = stuClass.getMethods();
        System.out.println("获取所有public方法");
        for (Method m: pubMethods) {
            System.out.println(m);
        }

        //获取所有成员方法
        Method[] allMethods = stuClass.getDeclaredMethods();
        System.out.println("获取所有成员方法");
        for (Method m: allMethods) {
            System.out.println(m);
        }

        try {
            //获取单个公有方法
            Method show1 = stuClass.getMethod("show1", String.class); //  name : 方法名；Class … : 形参的Class类型对象
            System.out.println("获取单个公有方法");
            System.out.println(show1);
            // 创建对象
            Object obj = stuClass.getConstructor().newInstance();
            // 调用方法
            show1.invoke(obj, "lewis");

            //获取单个私有方法
            Method show4 = stuClass.getDeclaredMethod("show4", int.class);
            System.out.println("获取单个私有方法");
            System.out.println(show4);
            show4.setAccessible(true);
            show4.invoke(obj, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取student类中的main方法
        try {
            Method main = stuClass.getMethod("main", String[].class);
            //调用main方法
            // 第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组
            // 这里拆的时候将  new String[]{“a”,”b”,”c”} 拆成3个对象。。。所以需要将它强转.
            main.invoke(null, (Object)new String[]{"a", "b", "c"});
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过反射运行配置文件内容
        Class className = Class.forName(getValue("className"));
        Method method = className.getMethod(getValue("methodName"));
        method.invoke(className.getConstructor().newInstance());

        //通过反射越过泛型检查
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("cba");

        Class arrClass = arrayList.getClass();
        Method addMethod = arrClass.getMethod("add",Object.class);
        addMethod.invoke(arrayList, 100);
        for (Object obj: arrayList) {
            System.out.println(obj);
        }
    }

    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("/reflection/pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }

}

class Student {
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    // 默认
    Student(String str) {
        System.out.println(str);
    }

    // 无参
    public Student() {
        System.out.println("无参构造方法");
    }

    // 有参
    public Student(char name) {
        System.out.println(name);
    }

    // 多参
    public Student(String name, int age) {
        System.out.println(name + age);
    }

    // 受保护的
    protected Student(boolean n) {
        System.out.println(n);
    }

    //私有
    private Student(int age) {
        System.out.println(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    public void show(){
        System.out.println("is show()");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行了");
    }
}
