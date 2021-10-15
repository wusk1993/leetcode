package com.leetcode.problems.others;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/13 21:38
 */
public class LC13 extends TestCase {

    public void test1() {
        System.out.println(romanToInt("MCDLXXVI"));
    }

    Map<Character, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        init();
        int cnt = 0;
        int l = 0;
        while (l < s.length()) {
            char c = s.charAt(l);
            if (l < s.length() - 1) {
                int x = s.charAt(l+1);
                if ('I' == c) {
                    if ('V' == x) {
                        cnt += 4;
                        l ++;
                    } else if ('X' == x) {
                        cnt += 9;
                        l ++;
                    } else {
                        cnt += 1;
                    }

                } else if ('X' == c) {
                    if ('L' == x) {
                        cnt += 40;
                        l ++;
                    } else if ('C' == x) {
                        cnt += 90;
                        l ++;
                    } else {
                        cnt += 10;
                    }
                } else if ('C' == c) {
                    if ('D' == x) {
                        cnt += 400;
                        l++;
                    } else if ('M' == x) {
                        cnt += 900;
                        l++;
                    } else {
                        cnt += 100;
                    }
                } else {
                    cnt += map.get(c);
                }
            } else {
                cnt += map.get(c);
            }
            l++;
        }
        return cnt;
    }

    public void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}