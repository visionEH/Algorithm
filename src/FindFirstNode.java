/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstNode {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
           if (pHead1 == null || pHead2 == null){
               return null;
           }
           int num1 = getLength(pHead1);
           int num2 = getLength(pHead2);
           if (num1 > num2){
               int dis = num1 - num2;
               while (dis > 0){
                   pHead1 = pHead1.next;
                   dis--;
               }
           } else{
               int dis = num2 - num1;
               while (dis > 0){
                   pHead2 = pHead2.next;
                   dis--;
               }
           }
           while (pHead1 != null && pHead2 !=null){
               if (pHead1 == pHead2){
                   break;
               } else {
                   pHead1 = pHead1.next;
                   pHead2 = pHead2.next;
               }
           }
           return pHead1;
    }

    public int getLength(ListNode node){
        ListNode cur = node;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
