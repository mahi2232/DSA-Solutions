BFS:

class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] clr = new int[v];
        Arrays.fill(clr, -1);
        for(int i = 0; i < v; i++) {
            if(clr[i] == -1) {
                if(bfs(i, v, graph, clr) == false) return false;
            }
        }
        return true;
    }

    private boolean bfs(int u, int v, int[][] graph, int[] clr) {
        clr[u] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(u);

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : graph[node]) {
                if(clr[it] == -1) {
                    clr[it] = clr[node] == 1 ? 0 : 1;
                    q.add(it);
                }
                else if(clr[it] == clr[node]) return false;
            }
        }
        return true;
    }
}


DFS:

class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] clr = new int[v];
        Arrays.fill(clr, -1);
        for(int i = 0; i < v; i++) {
            if(clr[i] == -1) {
                if(dfs(i, 0, graph, clr) == false) return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int col, int[][] graph, int[] clr) {
        clr[u] = col;
        for(int it : graph[u]) {
            if(clr[it] == -1) {
                if(dfs(it, 1-col, graph, clr) == false) return false;
            }
            else if(clr[it] == col) return false;
        }
        return true;
    }
}

Time Complexity = O(v+e)
Space Complexity = o(v)
