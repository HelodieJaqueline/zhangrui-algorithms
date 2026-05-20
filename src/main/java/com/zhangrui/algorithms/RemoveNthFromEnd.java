package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/18 17:10
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int step = 0;
        while (fast != null) {
            fast = fast.next;
            if (step >= n + 1) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
