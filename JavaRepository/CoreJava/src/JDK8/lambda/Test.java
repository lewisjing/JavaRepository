package JDK8.lambda;

public class Test {
    public static void main(String[] args) {
        // lambda作用域
        // 访问局部变量
        final int num = 1;
        Converter<Integer, String> converter = (from) -> String.valueOf(from + num);

        // 这里的num2可以不声明为final,但是不能被后面的代码所修改(也就是隐形的final)
        int num2 = 1;
        Converter<Integer, String> converter1 = (from) -> String.valueOf(from + num2);
//        num2 = 10;


        //访问字段和静态变量,参考下方class Lambda4

        //访问默认接口方法
        //无法从 lambda 表达式中访问默认方法
//        Formula formula = (a) -> sqrt(a * 100);

    }
}

class Lambda4 {
    static int outStaticNum;
    int outNum;

    void testScope() {
        Converter<Integer, String> stringConverter = (from) -> {
            outNum = 23;
            return String.valueOf(outNum);
        };

        Converter<Integer, String> stringConverter1 = (from) -> {
            outStaticNum = 10;
            return String.valueOf(outStaticNum);
        };
    }
}

interface Converter<F, T> {
    T convert(F from);
}

interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
