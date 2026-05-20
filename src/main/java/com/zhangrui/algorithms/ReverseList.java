package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/18 14:16
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
