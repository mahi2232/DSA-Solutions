BRUTE FORCE SOLUTION:
Time Complexity = O(n2)
Space Complexity = O(1)

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                int sum = nums[i] + nums[j];
                if(sum == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return new int []{};
    }
}


OPTIMAL SOLUTION: 
Time Complexity = O(n)
Space Complexity = O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
