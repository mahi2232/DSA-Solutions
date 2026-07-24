BRUTE APPROACH (GIVES TLE):

  class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> used = new ArrayList<>();
        used.add(beginWord);
        int lvl = 0;

        while(!q.isEmpty()) {
            ArrayList<String> l = q.peek();
            q.remove();
            if(l.size() > lvl) {
                lvl++;
                for(String s : used) {
                    st.remove(s);
                }
            }

            String word = l.get(l.size()-1);
            if(word.equals(endWord)) {
                if(ans.size() == 0) ans.add(l);
                else if(ans.get(0).size() == l.size()) ans.add(l);
            }
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);
                    if(st.contains(newWord) == true) {
                        l.add(newWord);
                        ArrayList<String> temp = new ArrayList<>(l);
                        q.add(temp);
                        used.add(newWord);
                        l.remove(l.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}

Time Complexity = O(26*L^2) --> where L is the length of Word
Space Complexity = O(P*D) --> where P is the number of paths and D is the number of words
