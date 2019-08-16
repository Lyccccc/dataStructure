package net.coderchen.practice.sort;

import java.util.zip.CheckedOutputStream;

/**
 * @author Liuyuchen
 * @date 2019/08/16
 * 计数排序应用（桶排序特殊情况）
 * 例：考生按照分数排序，降排序
 */
public class CountingSort {

    /**
     * 成绩数组
     */
    private static int[] points = new int[]{77, 22, 34, 21, 66, 77, 32, 65, 99, 100, 8, 77, 86, 95, 100, 98, 80, 60, 60,
            77, 84, 90, 66, 69, 81, 53, 85, 89, 78, 90, 81, 52, 67, 79, 80, 99, 100, 94, 92, 91, 57, 68, 91, 34, 66, 77,
            90, 67, 74, 73, 63, 74, 68, 90, 64, 98, 87, 87, 68, 80, 83, 76, 75, 89, 46, 30, 69, 88, 83, 93, 65, 75, 70,
            67, 96, 61, 46, 79, 88, 89, 46, 92, 35, 67, 64, 67, 34, 90, 54, 56, 80, 82, 75, 84, 67, 67, 80, 90, 30, 60};


    public static void main(String[] args) {
        countingSort(points, 101);
    }

    /**
     * 计数排序
     * @param array 需要排序的数组
     * @param types 类型总数
     */
    public static void countingSort(int[] array, int types){
        //辅助数组1，保存每个分数有多少人，0~100 分
        int[] arr = new int[types];
        //辅助数组2，保存小于等于当前分数的有多少人
        int[] arr2 = new int[types];

        //1、遍历成绩数组，写入分数数组
        for (int point : array) {
            arr[point]++;
        }

        //2、计算小于等于当前分数的有多少人
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr2[i] = sum;
        }
        //验证
        System.out.println("arr：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("arr2：");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println("");

        //3、申请临时数组，保存排序结果
        int[] tmp = new int[array.length];
        //为保证稳定排序，从后往前遍历
        for (int point : array) {
            tmp[--arr2[point]] = point;
        }

        //4、复制回原数组
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[tmp.length - i - 1];
        }
        System.out.println("points：");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


}
