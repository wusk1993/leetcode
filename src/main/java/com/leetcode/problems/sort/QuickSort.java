package com.leetcode.problems.sort;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/10/19 22:47
 */
public class QuickSort extends TestCase {
    public void test1() {
        int[] nums = {1, 8, 3, 10, 1, 0, 21, 3};
        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        sort(nums, left, l - 1);
        sort(nums, l + 1, right);
    }
}