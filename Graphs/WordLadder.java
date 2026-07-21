class Pair {
    String str;
    int num;

    Pair(String str, int num) {
        this.str = str;
        this.num = num;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.peek().str;
            int steps = q.peek().num;
            q.remove();

            if(word.equals(endWord) == true) return steps;

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);
                    if(st.contains(newWord) == true) {
                        st.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

Time Complexity = O(n*m^2*26)
Space Complexity = O(m*n)
