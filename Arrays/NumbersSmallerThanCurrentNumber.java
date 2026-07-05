class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j]) cnt++;
            }
            ans[k++] = cnt;
        }
        return ans;
    }
}

Time Complexity = O(n2)
Space Complexity = O(n)


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] arr = new int[n];
        int[] buckets = new int[101];
        for(int i=0;i<n;i++){
                 buckets[nums[i]]++;
        }
        for(int i=1;i<buckets.length;i++){
            buckets[i]+=buckets[i-1];
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0)
            arr[i]=0;
            else
            {
              arr[i]=buckets[nums[i]-1];
            }
        }
        return arr;
    }
}


Time Complexity = O(n)
Space Complexity = O(1)
