class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode low = head;
        ListNode high = head;

        while(high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
        }

        return low;
    }
}


Time Complexity = O(n)
Space Complexity = O(1)
