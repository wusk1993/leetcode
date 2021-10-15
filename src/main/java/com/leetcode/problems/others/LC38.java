package com.leetcode.problems.others;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/10/15 19:33
 */
public class LC38 extends TestCase {

    public void test1() {
        System.out.println(countAndSay(1));
    }

    public String countAndSay(int n) {
        String res = "2";
        for (int i = 0; i < n - 1; i++) {
            res = des(res);
        }
        return res;
    }

    public String des(String s) {
        String res = "";
        char[] array = s.toCharArray();
        int t = 0;
        while (t < array.length) {
            char c = array[t];
            int x = t + 1;
            int cnt = 1;
            while (x < array.length) {
                if (c == array[x]) {
                    cnt++;
                } else {
                    break;
                }
                x++;
            }
            t = x;
            res += (cnt + String.valueOf(c));
        }
        return res;
    }
}