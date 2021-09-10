package com.leetcode.problems.listnode;

import java.util.*;

import com.leetcode.data_structure.ListNode;
import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/10 16:48
 */
public class LC25 extends TestCase {

    public void test1() {
        ListNode root = ListNode.convert(1,2,3,4,5);
        ListNode reverse = reverseKGroup(root, 2);
        ListNode.print(reverse);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode start = head;
        while (start != null) {
            int len = 1;
            ListNode tmp = start;
            while (len < k && tmp != null) {
                tmp = tmp.next;
                len++;
            }
            if (len == k && tmp != null) {
                ListNode next = tmp.next;
                tmp.next = null;
                ListNode node = reverse(start);
                tail.next = node;
                tail = start;
                start = next;
                if (dummy.next == null) {
                    dummy.next = node;
                }
            } else {
                tail.next = start;
                break;
            }

        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}