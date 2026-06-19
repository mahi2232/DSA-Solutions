class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int cnt = 0;
        ListNode temp = head;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }

        ListNode temp1 = head;
        ListNode temp2 = head;
        for(int i = 1; i <= k%cnt; i++) {
            temp2 = temp2.next;
        }

        while(temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp2.next = head;
        head = temp1.next;
        temp1.next = null;

        return head;
    }
}

Time complexity = O(n)
Space Complexity = O(1)
