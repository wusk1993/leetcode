package com.leetcode.problems.greedy;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/29 15:41
 */
public class LC517 extends TestCase {

    public void test1() {
        int[] machines = {1, 0, 5};
        System.out.println(findMinMoves(machines));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE + 1));
    }

    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}