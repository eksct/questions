package 链表;

public class _141_环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head==null || head.next ==null) return false;
        ListNode stand = head;
        ListNode end = head.next.next;
        while (end !=null && end.next != null){
            if (stand.equals(end))return true;
            stand = stand.next;
            end = end.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new _141_环形链表().new ListNode(3);
        head.next =  new _141_环形链表().new ListNode(2);
        head.next.next =  new _141_环形链表().new ListNode(0);
        head.next.next.next =  new _141_环形链表().new ListNode(-4);
//        head.next.next.next = head.next;
        new _141_环形链表().hasCycle(head);
    }
}
