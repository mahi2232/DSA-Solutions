lass Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        for(int i = 0; i < left-1; i++) {
            prev = prev.next;
            curr = curr.next;
        }

        ListNode sublist = curr;
        ListNode temp = null;

        for(int i = 0; i <= right - left; i++) {
            ListNode nxt = curr.next;
            curr.next = temp;
            temp = curr;
            curr = nxt;
        }

        prev.next = temp;
        sublist.next = curr;

        return dummy.next;
    }
}




Time Complexity = O(n)
Space Complexity = O(1)
