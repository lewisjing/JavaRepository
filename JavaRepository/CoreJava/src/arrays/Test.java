package arrays;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // *************排序 sort****************
        int a[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        // sort(int[] a)方法按照数字顺序排列指定的数组。
        Arrays.sort(a);
        System.out.println("Arrays.sort(a):");
        for (int i : a) {
            System.out.print(i);
        }
        // 换行
        System.out.println();


        // sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
        int b[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        Arrays.sort(b, 2, 6);
        System.out.println("对数组中下表在[2,6)之间的元素排序");
        for (int i : b) {
            System.out.print(i);
        }
        // 换行
        System.out.println();


        int c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        // parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
        Arrays.parallelSort(c);
        System.out.println("Arrays.parallelSort(c)：");
        for (int i : c) {
            System.out.print(i);
        }
        // 换行
        System.out.println();


        // parallelSort给字符数组排序，sort也可以
        char d[] = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        Arrays.parallelSort(d);
        System.out.println("Arrays.parallelSort(d)：");
        for (char d2 : d) {
            System.out.print(d2);
        }
        // 换行
        System.out.println();


        // *************查找 binarySearch()****************
        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        // 排序后再进行二分查找，否则找不到
        Arrays.sort(e);
        System.out.println("原有数组：" + Arrays.toString(e));
        int s = Arrays.binarySearch(e, 'c');
        System.out.println("字符c在数组的位置：" + s);


        // *************比较 equals****************
        char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        char[] g = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        /*
         * 元素数量相同，并且相同位置的元素相同。 另外，如果两个数组引用都是null，则它们被认为是相等的 。
         */
        // 输出true
        System.out.println("Arrays.equals(e, f):" + Arrays.equals(f, g));


        // *************填充fill(批量初始化)****************
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        // 数组中所有元素重新分配值
        Arrays.fill(h, 3);
        System.out.println("Arrays.fill(g, 3)：");
        // 输出结果：333333333
        for (int i : h) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        int[] i = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        // 数组中指定范围元素重新分配值
        Arrays.fill(i, 0, 2, 9);
        System.out.println("Arrays.fill(h, 0, 2, 9);：");
        // 输出结果：993333666
        for (int l : i) {
            System.out.print(l);
        }
        System.out.println();


        // *************转字符串 toString()****************
        /*
         * 返回指定数组的内容的字符串表示形式。
         */
        char[] k = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(Arrays.toString(k));// [a, f, b, c, e, A, C, B]


        // *************转列表 asList()****************
        /*
         * 返回由指定数组支持的固定大小的列表。
         * （将返回的列表更改为“写入数组”。）该方法作为基于数组和基于集合的API之间的桥梁，与Collection.toArray()相结合 。
         * 返回的列表是可序列化的，并实现RandomAccess 。
         * 此方法还提供了一种方便的方式来创建一个初始化为包含几个元素的固定大小的列表如下：
         */
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(stooges);


        // *************复制 copy****************
        // copyOf 方法实现数组复制,h为数组，6为复制的长度
        int[] p = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int m[] = Arrays.copyOf(p, 6);
        System.out.println("Arrays.copyOf(h, 6);：");
        // 输出结果：123333
        for (int j : m) {
            System.out.print(j);
        }
        // 换行
        System.out.println();
        // copyOfRange将指定数组的指定范围复制到新数组中
        int j[] = Arrays.copyOfRange(h, 6, 11);
        System.out.println("Arrays.copyOfRange(h, 6, 11)：");
        // 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
        for (int j2 : j) {
            System.out.print(j2);
        }
        // 换行
        System.out.println();
    }
}
