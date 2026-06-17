class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int l = 0;
        int r = str.length-1;

        while(l<=r) {
            while(l<r && !Character.isLetterOrDigit(str[l])) {
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(str[r])) {
                r--;
            }
            if(Character.toLowerCase(str[l]) != Character.toLowerCase(str[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

Time Complexity = O(n)
Space Complexity = O(n)
