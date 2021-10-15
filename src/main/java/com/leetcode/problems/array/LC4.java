package com.leetcode.problems.array;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/14 10:47
 */
public class LC4 extends TestCase {

    public void test1() {
        int[] nums1 = {};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        List<Integer> list = new ArrayList<>();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mod = (len1 + len2) % 2;
        int mid = (len1 + len2 - 1) / 2;
        double result = 0.0;
        int m = 0;
        int n = 0;
        int idx = 0;
        while (m < len1 && n < len2) {
            if (nums1[m] < nums2[n]) {
                if (idx == mid) {
                    result += nums1[m];
                    if (mod == 1) {
                        return result;
                    }
                }
                if (idx == mid + 1) {
                    result += nums1[m];
                    return result / 2.0;
                }
                m++;
            } else {
                if (idx == mid) {
                    result += nums2[n];
                    if (mod == 1) {
                        return result;
                    }
                }
                if (idx == mid + 1) {
                    result += nums2[n];
                    return result / 2.0;
                }
                n++;
            }
            idx++;
        }
        while (m < len1) {
            if (idx == mid) {
                result += nums1[m];
                if (mod == 1) {
                    return result;
                }
            }
            if (idx == mid + 1) {
                result += nums1[m];
                return result / 2.0;
            }
            m++;
            idx++;

        }
        while (n < len2) {
            if (idx == mid) {
                result += nums2[n];
                if (mod == 1) {
                    return result;
                }
            }
            if (idx == mid + 1) {
                result += nums2[n];
                return result / 2.0;
            }
            n++;
            idx++;
        }
        return result;
    }
}