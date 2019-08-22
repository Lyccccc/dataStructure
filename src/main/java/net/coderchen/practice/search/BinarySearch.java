package net.coderchen.practice.search;

/**
 * @author Liuyuchen
 * @date 2019/08/21
 * 二分查找
 */
public class BinarySearch {
    /**
     * 递增数组
     */
    private static int[] arr = new int[]{7, 12, 19, 21, 24, 26, 30, 36, 45, 49, 57, 59, 61, 62, 66, 77, 80, 89, 99, 100};

    public static void main(String[] args) {
        System.out.println(binarySearch(arr, 49));
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearch(arr, 100));
        System.out.println(binarySearch(arr, 50));
    }

    public static int binarySearch(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            //找中点
            int middle = (low + high) / 2;
            if(value == arr[middle]){
                return middle;
            }
            if(value > arr[middle]){
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        return -1;
    }
}
