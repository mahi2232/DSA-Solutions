class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int cnt = 0;

        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i, isConnected, visited);
            }
        }
        return cnt;
    }

    private void dfs(int node, int[][] arr, boolean[] visited) {
        visited[node] = true;
        for(int i = 0; i < arr.length; i++) {
            if(arr[node][i] == 1 && !visited[i]) {
                dfs(i, arr, visited);
            }
        }
    }
}
