package org.zhan.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 */
public class T2Soluction {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int add = 0;
        while(l1 != null) {
            if (l2 != null) {
                int temp = l1.val + l2.val + add;
                add = temp / 10;
                if (current != null) {
                    ListNode ln = new ListNode(temp % 10);
                    current.next = ln;
                    current = current.next;
                } else {
                    result = new ListNode(temp % 10);
                    current = result;
                }
                l2 = l2.next;
            } else {
                if (current != null) {
                    int temp = l1.val + add;
                    add = temp / 10;
                    ListNode ln = new ListNode(temp % 10);
                    current.next = ln;
                    current = current.next;
                } else {
                    result = new ListNode(l1.val);
                    current = result;
                }
            }
            l1 = l1.next;
        }
        while(l2 != null) {
            if (current != null) {
                int temp = l2.val + add;
                add = temp / 10;
                ListNode ln = new ListNode(temp % 10);
                current.next = ln;
                current = current.next;
            } else {
                result = new ListNode(l2.val);
                current = result;
            }
            l2 = l2.next;
        }
        if (add != 0) {
            ListNode ln = new ListNode(1);
            current.next = ln;
        }
        return result;
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
