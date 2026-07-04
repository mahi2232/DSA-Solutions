class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int p1 = 0;
        int p2 = n;
        int k = 0;

        while(p1 < n && p2 < 2*n) {
            ans[k++] = nums[p1++];
            ans[k++] = nums[p2++];
        }
        return ans;
    }
}

Time Complexity = O(n)
Space Complexity = O(n)
