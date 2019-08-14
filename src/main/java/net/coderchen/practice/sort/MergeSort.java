package net.coderchen.practice.sort;

import javafx.scene.web.WebEngine;

/**
 * @author Liuyuchen
 * @date 2019/08/14
 * 归并排序
 */
public class MergeSort {
    private static int[] arr = new int[]{11, 57, 69, 123, 623, 71, 77, 12, 67, 18, 132, 82, 98, 121, 3, 68, 62, 72, 54, 22};

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    private static void mergeSort(int[] arr, int begin, int end){
        if(begin >= end){
            return;
        }
        int middle = (begin + end) / 2;
        //左半部分
        mergeSort(arr, 0, middle);
        //右半部分
        mergeSort(arr, middle+1, end);
        //合并
        merge(arr, begin, middle, end);
    }

    private static void merge(int[] arr, int begin, int middle, int end){
        int length = end - begin + 1;
        int[] tmp  = new int[length];
        int arrLeftLength = middle - begin + 1;
        int arrRightLength = end - middle;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < length; i++) {
            //左边已处理完
            if(leftIndex + 1 > arrLeftLength){
                tmp[i] = arr[middle + 1 + rightIndex++];
                continue;
            }
            //右边已处理完
            if(rightIndex + 1 > arrRightLength){
                tmp[i] = arr[begin + leftIndex++];
                continue;
            }
            if(arr[begin + leftIndex] > arr[middle + 1 + rightIndex]){
                tmp[i] = arr[middle + 1 + rightIndex];
                rightIndex++;
            }else{
                tmp[i] = arr[begin + leftIndex];
                leftIndex++;
            }
        }
        //tmp复制回原数组；
        for (int i = 0; i < length; i++) {
            arr[begin + i] = tmp[i];
        }
    }
}
