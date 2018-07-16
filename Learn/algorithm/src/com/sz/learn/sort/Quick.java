package com.sz.learn.sort;

/**
 * @Author whd
 * @Date 2018/5/23 9:51
 * @Description
 **/
public class Quick {
    public static void quickSort(int[] arr, int i, int j) {
        if (i >= j) {
            return ;
        }

        int fval = arr[i];
        int l = i, r = j;
        while (l < r) {
            while (l < r && arr[r] > fval) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }

            while (l < r && arr[l] < fval) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }

        if (l == r) {
            arr[l] = fval;
        }

        quickSort(arr, i, l-1);
        quickSort(arr, r+1, j);
    }


    public static void main(String[] args) {
        int[] arr = {-1,3,8,0,1,9,6,5};
        quickSort(arr, 0, arr.length - 1);

        for (int r : arr) {
            System.out.println(r);
        }
    }
}
