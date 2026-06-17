BRUTE FORCE:
  Time Complexity = O(n3)
  Space Complexity = O(1)

  class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int maxLen = 1;
        int start = 0;

        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (isPalindrome(s, left, right)) {
                    int len = right - left + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = left;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}


BETTER APPROACH:
  Time Complexity = O(n2)
  Space Comeplexity = O(1)

  class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int max_len = Math.max(odd, even);
            
            if(max_len > len) {
                len = max_len;
                start = i - (len-1)/2;
            }
        }

        return s.substring(start, start + len);        
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
