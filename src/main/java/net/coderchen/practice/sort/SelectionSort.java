package net.coderchen.practice.sort;

/**
 * @author Liuyuchen
 * @date 2019/04/02
 * @description 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 11, 5, 64, 22, 67, 99, 13, 84, 34, 64, 3, 65, 72, 56};
        arr = sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 具体实现
     * @param arr 待排序数组
     * @return 排序结果由小到大
     */
    public static int[] sort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                int k = i;
                if(arr[i] > arr[j]){
                    //记录下标
                    k = j;
                }
                if(k != i){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
