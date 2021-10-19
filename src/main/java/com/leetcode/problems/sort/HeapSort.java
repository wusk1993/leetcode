package com.leetcode.problems.sort;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/10/19 22:54
 */
public class HeapSort extends TestCase {
    public void test1() {
        int[] nums = {1, 8, 3, 10, 1, 0, 21, 3};
        adjustHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            sort(nums, 0, i - 1);
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sort(int[] nums, int pos, int r) {
        int left = pos * 2 + 1;
        if (left > r) {
            return;
        }
        if (left + 1 <= r && nums[left] < nums[left + 1]) {
            left++;
        }
        if (nums[pos] < nums[left]) {
            swap(nums, pos, left);
            sort(nums, left, r);
        }
    }

    public void adjustHeap(int[] nums) {
        int len = nums.length;
        for (int i = (len + 1)/2 - 1; i >= 0; i--) {
            init(nums, i);
        }
    }

    public void init(int[] nums, int pos) {
        int left = pos * 2 + 1;
        if (left + 1 < nums.length && nums[left] < nums[left + 1]) {
            left++;
        }
        if (nums[left] > nums[pos]) {
            swap(nums, pos, left);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}