class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            rev.add(new ArrayList<>());
        }
        int[] outdegree = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            for(int it : graph[i]) {
                rev.get(it).add(i);
                outdegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
            if(outdegree[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ans.add(node);
            for(int it : rev.get(node)) {
                outdegree[it]--;
                if(outdegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}


Time Complexity = O(v+e + vlogv)
Space Complexity = O(v+e)
