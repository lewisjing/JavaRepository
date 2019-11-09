package collections;

import java.util.*;

public class practice {
    public static void main(String[] args) {
        /*
        * Collection接口是集合类的根接口， List和Set都继承自Collection接口
        *
        * Set中不能包含重复的元素，
        * List中可以包含重复的元素，是一个有序集合，按照索引访问
        *
        * Map与Collection属于同一级别
        * Map中以键值对的形式存储数据，key值不能重复，value值可以重复，key值一般是String对象，但也可以是任何对象
        *
        * */

        /*
        * Question 1： ArrayList和LinkedList的区别
        *
        * 1. 是否保证线程安全： ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；
        * 2. 底层的数据结构： ArrayList 底层使用的是 Object 数组；
        *                     LinkedList 底层使用的是 双向链表 数据结构（JDK1.6之前为循环链表，JDK1.7取消了循环
        * 3. 插入和删除是否受元素位置的影响： ArrayList 采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响
        *                                     LinkedList 采用链表存储，所以插入，删除元素时间复杂度不受元素位置的影响
        *
        * 4. 是否支持快速随机访问： ArrayList支持，是通过下标来进行访问；  LinkedList不支持
        * 5. 内存空间占用： ArrayList的空 间浪费主要体现在在list列表的结尾会预留一定的容量空间
        *                   LinkedList的空间花费则体现在它的每一个元素都需要消耗比ArrayList更多的空间（因为要存放直接后继和直接前驱以及数据）
        * */

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();


        /*
        *  Question 2:
        *  RandomAccessj接口
        *
        * RandomAccess接口中什么都没有定义，笔者认为该接口不过是一个标识，标识实现这个接口的类有随机访问的功能
        * 在binarySearch方法中， 它要判断传入的list 是否 RamdomAccess 的实例，如果是，调用indexedBinarySearch（）方法，如果不是，那么调用iteratorBinarySearch（）方法
        *
        *
        * ArrayList 实现了 RandomAccess 接口， 而 LinkedList 没有实现。为什么呢？
        * 我觉得还是和底层数据结构有关！ArrayList 底层是数组，而 LinkedList 底层是链表。
        * 数组天然支持随机访问，时间复杂度为 O（1），所以称为快速随机访问。
        * 链表需要遍历到特定位置才能访问特定位置的元素，时间复杂度为 O（n），所以不支持快速随机访问。，
        * ArrayList 实现了 RandomAccess 接口，就表明了他具有快速随机访问功能。
        * RandomAccess 接口只是标识，并不是说 ArrayList 实现 RandomAccess 接口才具有快速随机访问功能的！
        * */


        /*
        * Question 3:
        * List遍历方式的选择：
        * 1. 实现了RandomAccess接口的list，优先选择普通for循环，其次foreach.
        * 2. 没有实现RandomAccess接口的list，优先选择iterator遍历(foreach遍历底层也是通过iterator实现的)，大size的数据，不要使用普通for循环
        * */


        /*
        * Question 4:
        * ArrayList 与 Vector 区别呢?为什么要用Arraylist取代Vector呢？
        *
        * Vector类的所有方法都是同步的，可以由两个线程安全的访问一个对象，但是一个线程在访问vector的时候，会耗费大量的实践
        *
        * ArrayList不是同步的，所以在不需要保证线程安全的情况下，建议使用ArrayList
         * */

        /*
        * Question 5:
        *
        * HashMap和HashTable的区别？
        *
        * 1. HashMap是线程不安全的，HashTable是线程安全的
        * 2. 因为线程安全问题，所以HashMap的效率要比HashTable要高
        * 3. 对Null Key 和 Null Value的支持： HashMap中，null可以作为键，也可以作为值，但是在HashTable中，null不能作为键，也能作为值
        * 4. 初始容量大小和每次扩充容量大小的不同？
        *       创建时如果不指定大小，Hashtable默认的初始大小为11， 之后每次扩容，容量变为原来的2n+1,
        *       HashMap的默认初始大小是16，之后每次扩容，容量会变为原来的2倍，
        *
        *       创建时如果指定了大小，Hashtable会直接使用给定的大小，
        *       而HashMap会扩充为2的幂次方大小，也就是说 HashMap 总是使用2的幂作为哈希表的大小
        *
        * 5. 底层的数据结构： JDK1.8之后的HashMap在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转换成红黑树，以减少搜索时间。Hashtable没有这样的机制
        * */

        HashMap<Object, Object> map = new HashMap();
        map.put(null, null);

        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put(null, null); // NullPointerException


        /*
        * HashMap和HashSet的区别？
        *
        * HashSet的底层时基于HashMap实现的，HashSet除了clone(), writeObject()、readObject()是 HashSet 自己不得不实现之外,
        * 其他方法都是直接调用 HashMap 中的方法。
        *
        *
        * HashMap实现了map接口，存储键值对，调用put()向map中添加元素，使用key来计算哈希值
        *
        * HashSet实现了Set接口，存储对象，调用add()向set中添加元素，使用成员对象和计算哈希值
        *
        * */

        HashSet set = new HashSet();


        /*
        * ConcurrentHashMap 和 HashTable的区别
        *
        * 主要体现在实现线程安全的方式上不同
        *
        *
        * 底层的数据结构：  1.7的ConcurrentHashMap底层采用数组+链表实现， 1.8采用数组+链表+红黑树来实现
        *                   HashTable是采用数组+链表的形式， 数组是HashMap的主体，而链表是为了解决哈希冲突
        *
        * 实现线程安全的方式： 简单来说就是ConcurrentHashMap采用分段锁， HashMap采用全表锁。
        * */


        /**
         * comparable 和 Comparator的区别
         *
         *  comparable接口实际上是出自java.lang包 它有一个 compareTo(Object obj)方法用来排序
         *
         *  comparator接口实际上是出自 java.util 包它有一个compare(Object obj1, Object obj2)方法用来排序
         */

        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(-1);
        arrayList1.add(3);
        arrayList1.add(3);
        arrayList1.add(-5);
        arrayList1.add(7);
        arrayList1.add(4);
        arrayList1.add(-9);
        arrayList1.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList1);
        // void reverse(List list)：反转
        Collections.reverse(arrayList1);
        System.out.println("反转之后的数组:");
        System.out.println(arrayList1);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList1);
        System.out.println("按自然排序的升序排列:");
        System.out.println(arrayList1);

        // 定制排序
        Collections.sort(arrayList1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("定制排序后：");
        System.out.println(arrayList1);


        TreeMap<Person, String> pdata = new TreeMap<Person, String>();
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");

        Set<Person> keys = pdata.keySet();
        for (Person person: keys) {
            System.out.println(person.getAge());
        }


        /*
        * 集合底层数据结构总结
        *
        *
        * List:
        *       ArrayList: object数组
        *       Vector: object数组
        *       LinkedList: 双向链表（1.6之前为循环链表， 1.7取消了循环）
        *
        * Set：
        *       HashSet(无序，唯一)：底层基于HashMap实现
        *       LinkedHashSet：  LinkedHashSet 继承于 HashSet，并且其内部是通过 LinkedHashMap 来实现的
        *       TreeSet（有序，唯一）：红黑树（自平衡的排序二叉树）
        *
        * Map:
        *       HashMap: JDK1.8之前是数组+链表的方式，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）。JDK1.8以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间
        *       Hashtable： 数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的
        *       TreeMap： 红黑树（自平衡的排序二叉树）
        *       LinkedHashMap: LinkedHashMap 继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。
        *                      另外，LinkedHashMap 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑
         *
        * */
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Person o) {
        // 按照年龄来排序
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return age;
    }
}
