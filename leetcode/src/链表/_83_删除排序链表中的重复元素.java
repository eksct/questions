package 链表;

public class _83_删除排序链表中的重复元素 {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null || head.next==null) return head;
        ListNode node = head;
        while (node.next!=null){
            if (node.val==node.next.val){
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return head;
    }
}
