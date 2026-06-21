class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[10001];
        Stack<Integer> st = new Stack<>();

        for(int i = m-1; i >=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            ans[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        for(int i = 0; i < n; i++) {
            nums1[i] = ans[nums1[i]];
        }

        return nums1;
    }
}


Time Complexity = O(n)
Space Comeplexity = O(n)
