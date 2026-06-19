
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;

        while(lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for(int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i+1 < lists.length ? lists[i+1] : null;
                temp.add(mergeList(l1, l2));
            } 
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode prev = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if(l1 != null) {
            prev.next = l1;
        }

        if(l2 != null) {
            prev.next = l2;
        }

        return dummy.next;
    }
}


Time Complexity = O(nlogk)
Space Complexity = O(1)
