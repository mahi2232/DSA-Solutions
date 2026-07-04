class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int dup = 0;
        int miss = 0;
        for(int i = 0; i < nums.length; i++)  {
            if(hm.containsKey(nums[i])) {
                dup = nums[i];
            }
            hm.put(nums[i], 1);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!hm.containsKey(i)) miss = i;
        }

        return new int[]{dup, miss};
    }
}

Time Complexity = O(n)
Space Complexity = O(n)
