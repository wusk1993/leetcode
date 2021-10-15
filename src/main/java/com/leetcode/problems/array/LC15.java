package com.leetcode.problems.array;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/13 21:03
 */
public class LC15 extends TestCase {

    public void test1() {
        int[] nums = {1,1,-2};
        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] < 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int lval = nums[l];
                int rval = nums[r];
                int sum = nums[l] + nums[r];
                if (sum + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r) {
                        if (nums[l] == lval) {
                            l++;
                        } else {
                            break;
                        }
                    }
                    while (l < r) {
                        if (nums[r] == rval) {
                            r--;
                        } else {
                            break;
                        }
                    }
                } else if (sum + nums[i] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

}