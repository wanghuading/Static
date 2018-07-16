package com.sz.learn.sort;

/**
 * @Author whd
 * @Date 2018/5/23 19:41
 * @Description
 **/
public class Shell {
    public static int[] shellSort(int[] a) {
        int len = a.length;
        int n = len / 2;
        while (n > 0) {
            int[] temp = new int[len];
            for (int i = 0; i < n; i++) {
                temp[i] = a[i];
                for (int k = i + n, j = i; k < len; j = k, k += n) {
                    while (j >= i && a[k] < temp[j]) {
                        temp[j + n] = temp[j];
                        j -= n;
                    }
                    temp[j + n] = a[k];
                }
            }
            a = temp;
            n = n / 2;
        }
        return a;
    }


    public static int[] shellSort1(int[] a) {
        int len = a.length;
        int n = len / 2;
        while (n > 0) {
            int[] temp = new int[len];
            // 初始化temp
            for (int i = 0; i < n; i++) {
                temp[i] = a[i];
            }
            int j = 0;
            for (int i = n; i < len; i++) {
                j = i;
                while (j - n >= 0 && temp[j-n] > a[i]) {
                    temp[j] = temp[j - n];
                    j -= n;
                }
                temp[j] = a[i];
            }
            a = temp;
            n = n / 2;
        }
        return a;
    }


    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */


    public static void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */

    public static void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;

                    }
                    arr[j] = temp;
                }
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
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] result = shellSort1(arr);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
