package com.sz.learn.alphastring;

/**
 * @Author whd
 * @Date 2018/5/15 17:01
 * @Description
 **/
public class KMP {

    public static int[] getNext(String pattern) {
        int pLen = pattern.length();
        char[] p = pattern.toCharArray();
        int[] next = new int[pLen];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1) {
            // p[k]表示前缀 p[j]表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
         return next;
    }

    public static int search(String s, String p) {
        int[] next = getNext(p);

        char[] sr = s.toCharArray();
        char[] pr = p.toCharArray();

        int si = 0, pi = 0;
        while (si < sr.length && pi < pr.length) {
            if (pi == -1 || sr[si] == pr[pi]) {
                ++si;
                ++pi;
            } else {
                pi = next[pi];
            }
        }

        if (pi == pr.length) {
            return si - pi;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "ABABDABABAB";
        System.out.println(search(s, "DA"));
    }
}
