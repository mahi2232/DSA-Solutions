BRUTE FORCE APPROACH:
  Time Complexity = O(n2)
  Space Complexity = O(1)

  class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp1 = head;

        while(temp1.next != null) {
            ListNode temp2 = temp1.next;
            ListNode min = temp1;
            while(temp2 != null) {
                if(temp2.val < min.val) {
                    min = temp2;
                }
                temp2 = temp2.next;
            }
            int t = temp1.val;
            temp1.val = min.val;
            min.val = t;

            temp1 = temp1.next;
        }
        return head;
    }
}


OPTIMAL APPROACH :
  Time Complexity = O(nlogn)
  Space Complexity = O(1)


  class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }

    private ListNode findMid(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val >= list2.val) {
                temp.next = list2;
                list2 = list2.next;
            }
            else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if(list1 != null) {
            temp.next = list1;
        }
        if(list2 != null) {
            temp.next = list2;
        }

        return dummy.next;
    }
}
