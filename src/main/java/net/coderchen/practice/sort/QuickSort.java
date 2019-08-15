package net.coderchen.practice.sort;

/**
 * @author Liuyuchen
 * @date 2019/08/14
 * 快速排序
 */
public class QuickSort {
    private static int[] arr = new int[]{11, 57, 69, 123, 623, 71, 77, 12, 67, 18, 132, 82, 98, 121, 3, 68, 62, 72, 54, 22};

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int begin, int end){
        if(begin >= end){
            return;
        }
        //以最后一个元素为基准
        int pivot = end;
        int key = arr[pivot];
        //i指向最后一个比pivot小的值
        int i = begin;
        for(int j = begin ; j <= end ; j++){
            if(arr[j] < key){
                if(i != j){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = tmp;
        quickSort(arr, begin, i-1);
        quickSort(arr, i+1, end);
    }
}
