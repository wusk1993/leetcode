package com.leetcode.problems.sort;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/10/19 23:09
 */
public class MergeSort extends TestCase {
    int[] tmp = null;
    public void test1() {
        int[] nums = {1, 8, 3, 10, 1, 0, 21, 3};
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, r);
        }
    }

    public void merge(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        int l1 = l;
        int l2 = mid + 1;
        int t = 0;
        while (l1 <= mid && l2 <= r) {
            if (nums[l1] < nums[l2]) {
                tmp[t++] = nums[l1++];
            } else {
                tmp[t++] = nums[l2++];
            }
        }
        while (l1 <= mid) {
            tmp[t++] = nums[l1++];
        }
        while (l2 <= r) {
            tmp[t++] = nums[l2++];
        }
        t = 0;
        for (int i = l; i <= r; i++) {
            nums[i] = tmp[t++];
        }
    }
}