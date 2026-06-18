class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }

        if(temp2 != null) {
            prev.next = temp2;
        }

        if(temp1 != null) {
            prev.next = temp1;
        }

        return dummy.next;
    }
}



Time Complexity = O(n)
Space Complexity = O(1)
