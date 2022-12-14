package org.luo.arithmetic.leetcode.listnode;

import org.luo.arithmetic.leetcode.MatrixFound;

/**
 * 合并有序列表
 * 题目：https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class No21 {

    /**
     * 迭代解法
     * 核心思想就是使用虚拟节点（链表题的核心解法之一） 然后进行遍历
     * @param list1
     * @param list2
     * @return
     */
    public  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = new ListNode(-1);
        ListNode b = a;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                b.next = p1;
                p1 = p1.next;
            } else {
                b.next = p2;
                p2 = p2.next;
            }
            b = b.next;
        }
        if (p1 != null) {
            b.next = p1;
        }
        if (p2 != null) {
            b.next = p2;
        }
        return a.next;
    }

    /**
     * 递归解法
     *
     *  公式:
     *   if:list1[0]<list2[0] result= list1[0]+merge(list1[1....到最后]+list2)
     *  否则result = list2[0]+merge[list1+list2[1...到最后]]
     *  跳出递归的条件:
     *  1.if(list1=null)==>return list2;
     *  2.if(list2==null)==>return list1;
     **
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
       ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode node2 = new ListNode(5);
        mergeTwoLists1(node,node2);
    }
}




