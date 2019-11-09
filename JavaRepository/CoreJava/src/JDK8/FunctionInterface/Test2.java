package JDK8.FunctionInterface;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.text.html.Option;
import java.lang.annotation.Repeatable;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {

        // Consumer 包含有一个有输入而无输出的accept接口方法； 还包含一个已经实现的andThen方法
        Consumer c = System.out::println;
        Consumer c1 = n -> System.out.println("f2" + n);

        //执行完c后再执行c2的Accept方法
        c.andThen(c1).accept("Hello World");

        //连续执行c的Accept方法
        c.andThen(c).andThen(c).andThen(c).accept("test1");


        // Function含有一个apply方法，包含一个输入与一个输出；
        // 还有compose与andThen及indentity三个方法

        Function<Integer, Integer> f = s -> s++;
        Function<Integer, Integer> f1 = s -> s * 2;

        /**
         * 下面表示在执行f时，先执行f1，并且执行f时使用f1的输出当作输入。
         * 相当于以下代码：
         * Integer a = f1.apply(1);
         * System.out.println(f.apply(a));
         */
        System.out.println(f.compose(f1).apply(1));

        /**
         * 表示执行f的Apply后使用其返回的值当作输入再执行f1的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(f1.apply(a));
         */
        System.out.println(f.andThen(f1).apply(1));


        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println(Function.identity().apply("a"));


        //Predicate  判断某个东西是否满足某种条件； 因此它包含test方法，根据输入值来做逻辑判断，其结果为True或者False。
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> p1 = o -> o.startsWith("t");

        p.test("test");
        p1.test("test");

        /**
         * negate: 用于对原来的Predicate做取反处理；
         * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
         */
        System.out.println(p.negate().test("test"));

        /**
         * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
         */
        System.out.println(p.and(p1).test("test"));

        /**
         * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
         */
        System.out.println(p.or(p1).test("test1"));

        //*****************************************************************************************************

//        Apply.apply();

//        Apply.parallelApply();

//        Apply.mapApply();

    }
}

class Apply {
    public static void apply() {
        // Stream的使用

        // 创建
        //创建空的stream对象
        Stream stream = Stream.empty();

        //通过集合类中的stream或者parallelStream方法创建
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream listStream = list.stream(); //获取串行的Stream对象
        Stream listParalleStream = list.parallelStream();  //获取并行的Stream对象

        //通过stream的of方法来创建
        Stream s = Stream.of("test");
        Stream s1 = Stream.of("a", "b", "c", "d");

        //通过Stream中的iterate方法创建
        //通过Stream中的generate方法创建
        //通过Stream中的concat方法连接两个Stream对象生成新的Stream对象

        // Stream对象的使用
        /**
         * Stream的方法大致分为两类：
         *          中间操作：将原始的Stream转换成另外一个Stream；如filter返回的是过滤后的Stream。
         *          终端操作：产生的是一个结果或者其它的复合操作；如count或者forEach操作。
         */

        // 以下是几个常用的方法示例

        //filter： 用于对Stream中的元素进行过滤，返回一个过滤后的Stream
        Stream<String> filterStream = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        filterStream.filter((n) -> n.contains("t")).forEach(System.out::println);

        //map: 接收一个Funcation参数，用其对Stream中的所有元素进行处理，返回的Stream对象中的元素为Function对原元素处理后的结果
        Stream<String> mapStream = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        mapStream.map(n -> n.concat("lewis")).forEach(System.out::println);

        //flatMap: 对原Stream中的所有元素使用传入的Function进行处理，每个元素经过处理后生成一个多个元素的Stream对象，然后将返回的所有Stream对象中的所有元素组合成一个统一的Stream并返回
        Stream<String> flatMapStream = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        // 将每一个元素的拆分成单个字母
        flatMapStream.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);

        //takeWhile. dropWhile  reduce   collect

        //reduce: 允许通过指定的函数来讲stream中的多个元素规约为一个元素，规约后的结果是通过Optional 接口表示的：
        Optional<String> reduced = Stream.of("test", "t1", "t2", "teeeee", "aaaa").reduce((d1, s2) -> {
            return d1 + '&' + s2;
        });

        System.out.println(reduced); //test&t1&t2&teeeee&aaa
    }

    public static void OptionalApply() throws Throwable {
        // Optional 是用来简化Java中对空值的判断处理，以防止出现各种空指针异常
        // Optional实际上是对一个变量进行封装，它包含有一个属性value，实际上就是这个变量的值

        //创建

        // empty: 创建空对象，其value为null
        Optional optional = Optional.empty();

        // of:  根据传入的值构建一个Optional对象; 传入的值必须是非空值，否则如果传入的值为空值，则会抛出空指针异常。
        Optional optional1 = Optional.of("test");

        // ofNullable: 根据传入值构建一个Optional对象 传入的值可以是空值，如果传入的值是空值，则与empty返回的结果是一样的。
        Optional optional2 = Optional.ofNullable(null);

        //使用场景：

        //判断结果不为空之后使用
        // 以往的写法：
        String s = null;
        if (null != s) {
            System.out.println(s);
        }

        // optional的写法
        Optional<String> optionalS = Optional.ofNullable(null);
        optionalS.ifPresent(System.out::println);


        //变量为空时提供默认值
        // 以前的写法
        if (null == s) {
            s = "test";
        }

        // 现在的写法
        Optional<String> optionalS1 = Optional.ofNullable(null);
        System.out.println(optionalS1.orElse("test"));

        //变量为空时抛出异常，否则使用
        // 以前的写法
        if (null == s) {
            throw new Exception("test");
        }

        //现在的写法
        Optional optional3 = Optional.ofNullable(null);
        System.out.println(optional3.orElseThrow(() -> new Exception("test")));

    }

    public static void parallelApply () {
        // 并行流 Parallel Streams
        // 串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。

        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //分别用串行和并行两种方式对其进行排序，最后看看所用时间的对比

        //Sequential Sort 串行排序
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // Parallel Sort(并行排序)
        long t00 = System.nanoTime();
        long count1 = values.parallelStream().sorted().count();

        System.out.println(count);

        long t11 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t00);
        System.out.println(String.format("parallel sort took: %d ms", millis1));
    }

    public static void mapApply () {
        // map类型不支持streams,不过Map提供了一些新的有用的方法来处理一些日常任务
        // 你可以在键，值上创建专门的流或者通过 map.keySet().stream(),map.values().stream()和map.entrySet().stream()。

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            //putIfAbsent 阻止我们在null检查时写入额外的代码
            /*
            * put在放入数据时，如果放入数据的key已经存在与Map中，最后放入的数据会覆盖之前存在的数据，
            *
            * putIfAbsent在放入数据时，如果存在重复的key，那么putIfAbsent不会放入值。
            * */
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, value) -> {
            System.out.println(value);
        });

        /*
        *computeIfAbsent:  当key不存在是则执性后面的方法
        * computeIfPresent: 当key存在时执行后面的方法
        * */

        map.computeIfPresent(3, (num, value) -> value + num);
        System.out.println(map.get(3)); // val33

        map.computeIfPresent(9, (num, value) -> null);
        System.out.println(map.containsKey(9)); // false

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23)); // true

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3)); // val33

        // 在map里面删除键值全部匹配的项
        map.remove(3, "val");
        System.out.println(map.get(3)); //val33
        map.remove(3, "val33");
        System.out.println(map.get(3)); //null

        // 获取键对应的值，如果为null，则返回默认值
        String defaultValue = map.getOrDefault(42, "not-found");
        System.out.println(defaultValue); // not-found

        // merge: 如果key存在，则执行lambda表达式，表达式入参为oldVal和newVal(neVal即merge()的第二个参数)。表达式返回最终put的val。如果key不存在，则直接putnewVal。

        System.out.println(map.get(9));
        map.merge(9,"newVal", (oldValue, newValue) -> oldValue.concat(newValue));
        System.out.println(map.get(9));
        map.merge(9, "2Val", (oldValue, newValue) -> oldValue.concat(newValue));
        System.out.println(map.get(9));

    }

    public static void dateApply () {

    }

    public static void annotationsApply () {
    }
}

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

// 老写法
@Hints({@Hint("hint1"), @Hint("hint2")})
class Person1 {

}

// 多重注解写法
@Hint("hint1")
@Hint("hint2")
class Person2 {

}