class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = new ListNode(-1, null);
        ListNode prev = temp;

        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val != cur.next.val) {
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
            }
            else {
                int num = cur.val;
                cur.next = cur.next.next;
                while(cur != null && cur.val == num) {
                    cur = cur.next;
                }
                prev.next = cur;
            }
            
        }
        return temp.next;
    }
}


Time Complexity = O(n)
Space Complexity = O(1)
