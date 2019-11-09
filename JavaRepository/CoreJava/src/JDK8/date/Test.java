package JDK8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        /*
        * Clock
        * Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
        * 某一个特定的时间点也可以使用 Instant 类来表示，Instant 类也可以用来创建旧版本的java.util.Date 对象。
        * */

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        /*
        * Timezones(时区)
        * 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。 抽象类ZoneId（在java.time包中）表示一个区域标识符。
        * 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域标识符。
         * */

        //输出所有区域标识符
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId z1 = ZoneId.of("Europe/Berlin");
        ZoneId z2 = ZoneId.of("Brazil/East");
        System.out.println(z1.getRules());
        System.out.println(z2.getRules());

        /*
        * LocalTime(本地时间)
        * LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 17:30:15。
        * 下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差：
        * */

        LocalTime now1 = LocalTime.now(z1);
        LocalTime now2 = LocalTime.now(z2);
        System.out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);

        // LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串.
        LocalTime late = LocalTime.of(23,59,59);
        System.out.println(late);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", dateTimeFormatter);
        System.out.println(leetTime);

        /*
        * LocalDate(本地日期)
        * LocalDate 表示了一个确切的日期，比如 2014-03-11。该对象值是不可变的，用起来和LocalTime基本一致。
        * 下面的例子展示了如何给Date对象加减天/月/年。另外要注意的是这些对象是不可变的，操作返回的总是一个新实例。
         * */

        LocalDate today = LocalDate.now();
        System.out.println("今天的日期: " + today);
        LocalDate tommorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("明天的日期：" + tommorrow);
        LocalDate yesterday = tommorrow.minusDays(2);
        System.out.println("昨天的日期：" + yesterday);
        LocalDate independenceDay = LocalDate.of(2019,Month.AUGUST, 25);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println("2019-08-25是周几：" + dayOfWeek);

        // 从字符串解析一个 LocalDate 类型和解析 LocalTime 一样简单,下面是使用 DateTimeFormatter 解析字符串的例子：
        String str1 = "2014==04==12 01时06分09秒";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime dateTime = LocalDateTime.parse(str1, formatter);
        System.out.println(dateTime);

        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy$$$MMM$$$dd HH小时");
        LocalDateTime dateTime1 = LocalDateTime.parse(str2, formatter1);
        System.out.println(dateTime1);

        // 再来看一个使用 DateTimeFormatter 格式化日期的示例
        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter2.format(rightNow));

        /*
        * LocalDateTime(本地日期时间)
        * LocalDateTime 同时表示了时间和日期，相当于前两节内容合并到一个对象上了。
        * LocalDateTime 和 LocalTime还有 LocalDate 一样，都是不可变的。
        * LocalDateTime 提供了一些能访问具体字段的方法。
         * */

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);

        Month month  = sylvester.getMonth();
        System.out.println(month);

        long minuteDay = sylvester.getLong(ChronoField.MICRO_OF_DAY);
        System.out.println(minuteDay);

        //只要附加上时区信息，就可以将其转换为一个时间点Instant对象，Instant时间点对象可以很容易的转换为老式的java.util.Date。
        Instant instant1 = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate1);

        // 格式化LocalDateTime和格式化时间和日期一样的，除了使用预定义好的格式外，我们也可以自己定义格式：
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter3);
        String string = formatter3.format(parsed);
        System.out.println(string);

    }
}
