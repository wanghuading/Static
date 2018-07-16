package com.sz.learn.sort;

/**
 * @Author whd
 * @Date 2018/5/22 22:20
 * @Description
 **/
public class Bubbling {
    public static int[] arraySort(int[] arr) {
        int len = arr.length;
        int jlen = 0;
        int temp = 0;
        for (int i = 0; i < len - 1; i++) {
            jlen = len - 1 - i;
            for (int j = 0; j < jlen; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {3,8,0,1,9,6,5};
        int[] result = arraySort(arr);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
