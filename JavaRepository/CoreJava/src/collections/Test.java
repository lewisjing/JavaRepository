package collections;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Collections 工具类和 Arrays 工具类常见方法总结
        // https://gitee.com/SnailClimb/JavaGuide/blob/master/docs/java/Basis/Arrays,CollectionsCommonMethods.md

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原始数组:");
        System.out.println(arrayList);

        // 反转
        Collections.reverse(arrayList);
        System.out.println("反转之后的数组：");
        System.out.println(arrayList);

        // 旋转
        // 当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
        Collections.rotate(arrayList, 4);
        System.out.println("旋转之后的数组：");
        System.out.println(arrayList);

        // 排序，默认是升序
        Collections.sort(arrayList);
        System.out.println("排序之后的数组：");
        System.out.println(arrayList);

        // 随机排序
        Collections.shuffle(arrayList);
        System.out.println("随机排序之后的数组：");
        System.out.println(arrayList);

        // 交换两个索引位置的元素
        Collections.swap(arrayList, 2, 5);
        System.out.println("交换之后的数组:");
        System.out.println(arrayList);

        // 定制排序的用法
        // void sort(List list, Comparator c) 定制排序，由Comparator控制排序逻辑
        Collections.sort(arrayList, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);

//        Test2.test();
        Test2.test2();
    }
}

class Test2 {
    public static void test() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(-3);
        arrayList2.add(-5);
        arrayList2.add(7);

        System.out.println("原始数组:");
        System.out.println(arrayList);

        System.out.println("获取最大值：");
        System.out.println(Collections.max(arrayList));

        System.out.println("获取最小值：");
        System.out.println(Collections.min(arrayList));

        System.out.println("将数组中的3全部替换成-3");
        Collections.replaceAll(arrayList, 3, -3);
        System.out.println(arrayList);

        System.out.println("统计-3出现的次数");
        System.out.println(Collections.frequency(arrayList, -3));

        System.out.println("统计list2在list中第一次出现的索引，找不到则返回-1:");
        System.out.println(Collections.indexOfSubList(arrayList, arrayList2));

        System.out.println("对List进行二分查找，返回索引，List必须是有序的, 查找元素7所在的位置");
        Collections.sort(arrayList);
        System.out.println(Collections.binarySearch(arrayList, 7));
    }

    public static void test2() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        HashSet<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(3);
        integers1.add(2);

        Map scores = new HashMap();
        scores.put("语文" , 80);
        scores.put("Java" , 82);

        //Collections.emptyXXX();创建一个空的、不可改变的XXX对象
        List<Object> list = Collections.emptyList();
        System.out.println(list);//[]
        Set<Object> objects = Collections.emptySet();
        System.out.println(objects);//[]
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        System.out.println(objectObjectMap);//{}


        //Collections.singletonXXX();
        List<ArrayList<Integer>> arrayLists = Collections.singletonList(arrayList);
        System.out.println(arrayLists);//[[-1, 3, 3, -5, 7, 4, -9, -7]]
        //创建一个只有一个元素，且不可改变的Set对象
        Set<ArrayList<Integer>> singleton = Collections.singleton(arrayList);
        System.out.println(singleton);//[[-1, 3, 3, -5, 7, 4, -9, -7]]
        Map<String, String> nihao = Collections.singletonMap("1", "nihao");
        System.out.println(nihao);//{1=nihao}

    }
}
