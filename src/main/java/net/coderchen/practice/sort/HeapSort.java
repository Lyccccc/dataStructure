package net.coderchen.practice.sort;

import net.coderchen.practice.adt.Heap;

/**
 * @author Liuyuchen
 * @date 2019/09/09
 */
public class HeapSort{
    /**
     * 含有26个元素的数组，第一个0无意义
     * 以此数组构建一个大小为25的堆
     */
    private static int[] arr = new int[]{0, 1, 55, 61, 32, 9, 13, 21, 8, 23, 47, 51, 67, 82, 331, 90, 22, 5, 77, 33, 213, 56, 157, 31, 59, 86};

    public static void main(String[] args) {
        Heap heap = new Heap(arr);
        heap.sort();
        System.out.println(heap.sortedString());
    }
}
