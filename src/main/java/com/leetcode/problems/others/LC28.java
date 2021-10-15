package com.leetcode.problems.others;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/10/12 11:21
 */
public class LC28 extends TestCase {

    public void test1() {
        System.out.println(divide(11, 3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        boolean negtive = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negtive = true;
        }
        int x = dividend > 0 ? -dividend : dividend;
        int y = divisor > 0 ? -divisor : divisor;

        int div = div(x, y);
        return negtive ? div : -div;
    }

    public int div(int x, int y) {
        if (x > y) {
            return 0;
        }
        int t = y;
        int res = -1;
        int prev = y;
        while (x <= y) {
            prev = y;
            res += res;
            y += y;
        }
        return res + div(x - prev , t);
    }
}