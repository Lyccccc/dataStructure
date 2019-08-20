package net.coderchen.practice.sort;

import java.util.Random;

/**
 * @author Liuyuchen
 * @date 2019/08/19
 * 基数排序
 * 例：1万个手机号排序
 */
public class RadixSort {
    private static Random random = new Random();
    private static String[] prefixs = new String[]{"130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
            "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "166", "180", "181",
            "182", "183", "184", "185", "186", "187", "188", "189", "199"};
    private static int PHONE_COUNTS = 10000;
    private static String[] phones = new String[PHONE_COUNTS];

    public static void main(String[] args) {
        generatePhoneNo();
        System.out.println("手机号列表：");
        for (String phone : phones) {
            System.out.println(phone);
        }
        for (int i = 11; i > 1; i--) {
            //先按照最后一位排序，然后按照倒数第二位排序，依次往前
            radixSort(phones, i);
        }
        System.out.println("排序后：");
        for (String phone : phones) {
            System.out.println(phone);
        }
    }

    /**
     * 随机生成1万个手机号
     */
    private static void generatePhoneNo(){
        for (int i = 0; i < PHONE_COUNTS; i++) {
            String prefix = prefixs[random.nextInt(prefixs.length)];
            String suffix = "";
            for (int j = 0; j < 8; j++) {
                suffix += random.nextInt(10);
            }
            phones[i] = prefix + suffix;
        }
    }


    public static void radixSort(String[] arr, int index){
        //辅助数组1
        int[] arr1 = new int[10];
        for (String s : arr) {
            int value  = Character.digit(s.charAt(index-1), 10);
            arr1[value]++;
        }
        int[] arr2 = new int[10];
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
            arr2[i] = sum;
        }
        //临时数组，存放排序后的手机号
        String[] tmp = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = Character.digit(arr[i].charAt(index-1), 10);
            tmp[--arr2[value]] = arr[i];
        }
        //复制回原数组
        //4、复制回原数组
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }
}
