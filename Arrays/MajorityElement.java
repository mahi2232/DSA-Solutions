BRUTE FORCE SOLUTION:
Time Complexity = O(n2)
Space Complexity = O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; 
    }
}


OPTIMAL SOLUTION:
Time Complexity = O(n)
Space Complexity = O(1)

class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int count = 0;
        int element = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(count == 0)
            {
                element = nums[i];
                count = 1;
            }

            else if(nums[i] == element)
            {
                count++;
            }

            else
            {
                count--;
            }
        }
        return element;
    }
}
