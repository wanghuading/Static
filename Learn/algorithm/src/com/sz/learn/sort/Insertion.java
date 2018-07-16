package com.sz.learn.sort;

/**
 * @Author whd
 * @Date 2018/5/23 10:31
 * @Description
 **/
public class Insertion {
    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        int narr[] = new int[len];
        narr[0] = arr[0];

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j >= 0 && arr[i] < narr[j]) {
                narr[j + 1] = narr[j];
                j--;
            }

            narr[++j] = arr[i];
            j = i;
        }
        return narr;
    }

    public static void insertionSort1(int[] arr) {
        int len = arr.length;

        int j = 0;
        for (int i = 1; i < len; i++) {
            j = i;
            while (j >= 0 && arr[j] < arr[j - 1]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    public static void main(String[] args) {
        int[] arr = {-1,3,8,0,1,9,6,5};
//        int[] result = insertionSort(arr);
        insertionSort1(arr);

        for (int r : arr) {
            System.out.println(r);
        }
    }
}
