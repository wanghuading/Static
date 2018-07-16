package com.sz.learn.alphastring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author whd
 * @Date 2018/5/16 8:36
 * @Description
 **/
public class DynamicPlan {
    /**
     * 硬币找零：动态规划算法
     *
     * @param values
     *            :保存每一种硬币的币值的数组
     * @param valueKinds
     *            :币值不同的硬币种类数量，即coinValue[]数组的大小
     * @param money
     *            :需要找零的面值
     * @param coinsUsed
     *            :保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {

            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }
    
    /**
      * @Author whd
      * @Date 2018/5/16 12:09
      * @Param [m:背包最大容量, n：商品个数, w：商品重量数组, p：商品价值数组]
      * @Return int[][]
      * @Description
      **/
    public static int[][] BackPack(int m, int n, int[] w, int[] p) {
        // 从[i][v] 表示前i件物品放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                // 当物品为i件重量为j时，如果第i件的重量（w[i=1])小于重量j时
                // c[i][j]为下列两种情况之一
                //(1)物品不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的价值加上当前物品
                if (w[i-1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]]) + p[i - 1]) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }


    public static int findLongPalindrome(String p) {
        if (p == null) {
            return 0;
        }

        int lenth = p.length();
        boolean[][] isPal = new boolean[lenth][lenth];
        int maxPalLength = 0;

        for (int i = 0; i < lenth - 1; i++) {
            isPal[i][i] = true;
            if (p.charAt(i) == p.charAt(i+1)) {
                isPal[i][i+1] = true;
                maxPalLength = 2;
            }
        }

        int subEnd = 0;
        for (int i = 3; i <= lenth; i++) {
            for (int j = 0; j <= lenth - i; j++) {
                subEnd = i + j - 1;
                if (isPal[j+1][subEnd-1] && p.charAt(j) == p.charAt(subEnd)) {
                    isPal[j][subEnd] = true;
                    maxPalLength = i;
                }
            }
        }

        return maxPalLength;
    }

    public static int findLongCommonStr(String p1, String p2) {
        int len1 = p1.length();
        int len2 = p2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int result = 0;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (p1.charAt(i - 1) == p2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return result;
    }

    //TODO将一个较大的钱，不超过1000的人民币，兑换成数量不限的100、50、10、5、2、1的组合，请问共有多少种组合呢？

    // 找出最长递增字符串
    public static String getLongInc(String p) {
        int len = p.length();
        int[] state = new int[len];
        int maxStation = 0, maxLength = 1;
        for (int i = 1; i < len; i++) {
            if (p.charAt(i-1) < p.charAt(i)) {
                state[i] = state[i-1] + 1;
                if (maxLength < state[i]) {
                    maxLength = state[i];
                    maxStation = i;
                }
            }
        }

        return p.substring(maxStation - state[maxStation], maxStation+1);
    }



    public static void main(String[] args) {

        /*// 硬币面值预先已经按降序排列
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        // 需要找零的面值
        int money = 63;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];

        makeChange(coinValue, coinValue.length, money, coinsUsed);*/


        /*int[] w = {3,4,5};
        int[] p = {4,5,6};
        int[][] r = BackPack(10,3, w, p);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(r[i][j]+"  ");
            }
            System.out.println();
        }*/

//        System.out.println(findLongPalindrome("abba"));
//        System.out.println(findLongCommonStr("abcdef", "abcddabcdellabc"));

        System.out.println(getLongInc("abcddabgkmcdellabc"));
    }
}
