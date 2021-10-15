package com.leetcode.problems.dp;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/21 11:39
 */
public class LC637 extends TestCase {

    public void test1() {
        int[] nums = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        int max = 1;
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    } else if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                }
            }
            max = Math.max(max, dp[i][0]);
        }

        int cnt = 0;
        for (int k = 0; k < nums.length; k++) {
            if (dp[k][0] == max) {
                cnt += dp[k][1];
            }
        }
        return cnt;
    }
}