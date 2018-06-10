package day5;

import java.util.List;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class FirstNode {
    public static void main(String[] args) {

    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
            if (pHead == null || pHead.next == null)
                return null;
            ListNode head = pHead ;
            ListNode second = pHead;
            while (second != null && second.next != null){
                head = head.next;
                second = second.next.next;
                if (head == second){
                    second = pHead;
                    while(head != second){
                        head = head.next;
                        second = second.next;
                    }
                    return head;
                }
            }
            return null;

    }
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
