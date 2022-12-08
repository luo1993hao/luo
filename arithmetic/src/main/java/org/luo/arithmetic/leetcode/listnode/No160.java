package org.luo.arithmetic.leetcode.listnode;

/**
 * 暴力解法：
 * 2个for循环 a==b来判断
 *巧妙解法:
 * 。把两段路让a,b都反复的走。如果A,B是相交的，则一定会在相交点相遇。
 *
 */
public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
