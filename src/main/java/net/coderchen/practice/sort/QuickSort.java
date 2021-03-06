package net.coderchen.practice.sort;

import net.coderchen.practice.util.ArrayUtil;

/**
 * @author Liuyuchen
 * @date 2019/08/14
 * 快速排序
 */
public class QuickSort {
    private static int[] arr = new int[]{11, 57, 69, 123, 623, 71, 77, 12, 67, 18, 132, 82, 98, 121, 3, 68, 62, 72, 54, 22};
    private static int[] arr2 = new int[]{11, 57, 69, 123, 623, 71, 77, 12, 67, 18, 132, 82, 98, 121, 3, 68, 62, 72, 54, 22};

    public static void main(String[] args) {
//        System.out.println("第一种：");
//        quickSort(arr, 0, arr.length-1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        System.out.println("第二种：");
//        quickSort2(arr2, 0, arr2.length - 1);
//        for (int i : arr2) {
//            System.out.println(i);
//        }

        int[] arr3 = ArrayUtil.generateArray(100, 1000);
        quickSort3(arr3, 0, arr3.length - 1);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
            if(i > 0){
                if(arr3[i] < arr3[i-1]){
                    System.out.println("false");
                }
            }
        }
    }

    /**
     * 参考极客时间https://time.geekbang.org/column/article/41913
     * @param arr
     * @param begin
     * @param end
     */
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

    /**
     * 第二种
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort2(int[] arr,int begin,int end){
        if(begin >= end){
            return;
        }
        int low = begin;
        int high = end - 1;
        int pivot = arr[end];
        while(low < high){
            //左 → 右
            while(low < high){
                if(arr[low] <= pivot){
                    low++;
                }else{
                    //交换low和high指定的元素
                    int tmp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = tmp;
                    break;
                }
            }
            //右 ← 左
            while(low < high){
                if(arr[high] >= pivot){
                    high--;
                }else{
                    //交换low和high指定的元素
                    int tmp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = tmp;
                    break;
                }
            }

        }
        //当high指向的元素大于pivot时，pivot放在数组中间
        if(arr[high] > pivot){
            int tmp = arr[end];
            arr[end] = arr[high];
            arr[high] = tmp;
        }
        quickSort2(arr, begin, high);
        quickSort2(arr, high + 1, end);
    }

    /**
     * 快速排序优化 三值取中法
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSort3(int[] arr, int begin, int end){
        if(begin >= end){
            return;
        }
        int pivot;
        //end - begin  > 5 时选择基准
        //三值取中法找pivot位置
        if(end - begin > 5){
            int middle = (begin + end) / 2;
            if(arr[begin] >= arr[middle] && arr[begin] <= arr[end]){
                pivot = begin;
            }else if(arr[middle] >= arr[begin] && arr[middle] <= arr[end]){
                pivot = middle;
            }else{
                pivot = end;
            }
        }else{
            pivot = end;
        }

        int key = arr[pivot];
        //i指向最后一个比pivot小的值
        int i = begin;
        for(int j = begin ; j <= end ; j++){
            if(arr[j] < key){
                if(i != j){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    //解决pivot交换后偏移问题
                    if(i == pivot){
                        pivot = j;
                    }
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
