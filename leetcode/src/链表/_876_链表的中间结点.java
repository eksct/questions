package 链表;

public class _876_链表的中间结点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode middleNode(ListNode head) {
        if (head==null || head.next==null) return head;
        int num=1;
        ListNode node = head;
        while (node.next!=null){
            num++;
            node = node.next;
        }
        int mid = 0;
        if (num % 2==0) mid = (num/2)+1;
        else mid = (num+1)/2;
        for (int i=1;i < mid;i++){
            head = head.next;
        }
        return head;
    }
}
