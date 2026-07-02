class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] res = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            res[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(coin <= i && res[i-coin] != Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i], 1+res[i-coin]);
                }
            }
        }

        if(res[amount] == Integer.MAX_VALUE) return -1;
        return res[amount];
    }
}

Time Complexity = O(m*n)
Space Complexity = O(n)
