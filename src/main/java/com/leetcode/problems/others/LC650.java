package com.leetcode.problems.others;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/19 21:16
 */
public class LC650 extends TestCase {
    public void test1() {
        System.out.println(minSteps(6));
    }

    public int minSteps(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 2;
            } else {
                dp[i] = i;
            }
        }
        System.out.println(dp[3]);
        return dp[n];
    }
}