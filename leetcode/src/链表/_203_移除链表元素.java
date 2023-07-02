package 链表;

public class _203_移除链表元素 {
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
    public ListNode removeElements(ListNode head, int val) {
        if (head==null || head.next ==null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode nodes = node;
//        node.next =head;
        while (nodes.next!=null){
            if (nodes.next.val==val){
                nodes.next =nodes.next.next;
                continue;
            }
            nodes=nodes.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = new _203_移除链表元素().new ListNode(1);
        head.next = new _203_移除链表元素().new ListNode(2);
        head.next.next = new _203_移除链表元素().new ListNode(3);
        ListNode st = new _203_移除链表元素().removeElements(head,3);
    }
}
