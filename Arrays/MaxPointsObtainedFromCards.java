class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = cardPoints[0];
        suffixSum[n-1] = cardPoints[n-1];

        for(int i = 1; i < n; i++) {
            prefixSum[i] = cardPoints[i] + prefixSum[i-1];
        }
        for(int i = n-2; i >= 0; i--) {
            suffixSum[i] = cardPoints[i] + suffixSum[i+1];
        }

        int max = 0;

        for(int left = 0; left <= k; left++) {
            int right = k - left;
            int sum = 0;
            if(left > 0) {
                sum+=prefixSum[left-1];
            }
            if(right > 0) {
                sum+=suffixSum[n-right];
            }

            max = Math.max(max, sum);
        }
        return max;
    }
}

Time Complexity = O(n)
Space Complexity = O(2n)
