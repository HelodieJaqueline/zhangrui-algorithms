package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/18 14:53
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                result.next = p1;
                p1 = p1.next;
            } else {
                result.next = p2;
                p2 = p2.next;
            }
            result = result.next;
        }
        if (p1 != null) {
            result.next = p1;
        }
        if (p2 != null) {
            result.next = p2;
        }
        return dummy.next;
    }

}
