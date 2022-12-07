package org.luo.arithmetic.leetcode.listnode;


/**
 * 环形链表 II
 * 相似题目:141 环形链表
 * 思路：快慢指针
 * a：从头结点到环第一个节点的距离
 * b:环节点的长度。n:绕环节点的长度
 * fast = 2slow
 * fast = slow+nb;
 * 可以算出：
 * slow = nb;
 * 从head结点走到入环点需要走 ： a + nb， 而slow已经走了nb，那么slow再走a步就是入环点了。
 *
 * 如果确定a:
 * 从head节点与相遇后的slow节点同时走。第一次相遇的时候距离就是a.
 * 因为对于任何一个节点。走到入环点的距离是a+nb。而相遇的时候。slow已经走了nb。此时从Head节点与slow节点同步走。一定在入环点相遇
 * （对于a的确认，还是不懂的同学画个图就明白了）。
 */
public class No142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
