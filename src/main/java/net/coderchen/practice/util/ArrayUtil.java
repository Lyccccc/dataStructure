package net.coderchen.practice.util;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/21
 */
public class ArrayUtil {

    /**
     * 生成一个指定大小的随机数组
     * @param capacity 数组大小
     * @param max 数组元素上界
     * @return 随机数组
     */
    public static int[] generateArray(int capacity, int max){
        if(capacity <= 0){
            return null;
        }
        int[] arr = new int[capacity];
        Random random = new Random();
        max = max + 1;
        for (int i = 0; i < capacity; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
}
