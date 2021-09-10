package com.leetcode.data_structure;

/**
 * @author wushaokang
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode convert(Integer... ints) {
        ListNode root = new ListNode();
        ListNode cur = root;
        for (Integer anInt : ints) {
            ListNode node = new ListNode(anInt);
            cur.next = node;
            cur = node;
        }
        return root.next;
    }

    public static void print(ListNode node) {
        ListNode tmp = node;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
