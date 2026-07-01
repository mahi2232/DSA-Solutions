class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int len = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            while(hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            len = Math.max(len, right-left+1);
        }
        return len;
    }
}

Time Complexity = O(n);
Space Complexity = O(1)
