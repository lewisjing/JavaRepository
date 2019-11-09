package autopacking;

public class AutoPacking {
    public static void main(String[] args) {
        // 自动装箱和自动拆箱是从JDK5.0开始有的
        // 装箱： 将基本数据类型用他们的引用类型包装起来
        Integer a = 100;
        Integer i = Integer.valueOf(100);

        //拆箱： 将包装类型转换成基本数据类型
        int b = a;
        int j = i.intValue();

        //todo
    }
}
