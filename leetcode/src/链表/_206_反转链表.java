package 链表;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _206_反转链表 {
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
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode pt = new ListNode(head.val,null);
        while (head.next!=null){//5 4 3
            pt =new ListNode(head.next.val,pt);
            head =head.next;
        }
        return pt;
    }
//    ListNode nots;
    public ListNode reverseList1(ListNode head) {//实际上给newnode传入了节点的地址值，对head的后继节点进行修改时也会影响到newnode
        if (head ==null || head.next==null) return head;//接着实际上并不是将节点赋予null，而是断开head与下个节点的链接，但是newnode仍指向head的下个节点
//             node.next = reverseList1(head.next);
            ListNode newnode = reverseList1(head.next);
            head.next.next=head;
            head.next=null;
        return newnode;

    }

    public static void main(String[] args) {
        ListNode head = new _206_反转链表().new ListNode(0,null);
//        ListNode node = new _206_反转链表().new ListNode();
        head.next = new _206_反转链表().new ListNode(5,null);
        head.next.next = new _206_反转链表().new ListNode(4,null);
        head.next.next.next = new _206_反转链表().new ListNode(3,null);
        head.next.next.next.next = new _206_反转链表().new ListNode(2,null);
        ListNode ts = new _206_反转链表().reverseList1(head);
        ListNode ts2 = new _206_反转链表().reverseList(ts);
    }
}
