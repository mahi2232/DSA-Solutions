RECURSIVE APPROACH:

  class Solution {
    public int rob(int[] nums) {
        return robber(nums, 0);
    }

    private int robber(int[] arr, int i) {
        if(i >= arr.length) return 0;
        int pos1 = arr[i] + robber(arr, i+2);
        int pos2 = robber(arr, i+1);
        return Math.max(pos1, pos2);
    }
}

Time Complexity = O(2^n)
Space Complexity = O(n)

DP + MEMORIZATION APPROACH:

  class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}


Time Complexity = O(n)
Space Complexity = O(n)
