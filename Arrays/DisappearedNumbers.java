class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!hm.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

Time Complexity = O(n)
Space Complexity = O(n)


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length)
        {
            int corrIdx = nums[i] - 1;
            if(nums[i] != nums[corrIdx])
            {
                int temp = nums[i];
                nums[i] = nums[corrIdx];
                nums[corrIdx] = temp;
            } else 
            {
                i++;
            }
        }

        for(int idx = 0; idx <nums.length; idx++)
        {
            if(nums[idx] != idx + 1)
            {
                result.add(idx+1);
            }
        }
        return result;
    }
}

Time Complexity = O(n)
Space Complexity = O(1)
