class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, vis, grid, n, m);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1) {
                dfs(i, m-1, vis, grid, n, m);
            }
        }
        for(int i = 0; i < m; i++) {
            if(vis[0][i] == 0 && grid[0][i] == 1) {
                dfs(0, i, vis, grid, n, m);
            }
            if(vis[n-1][i] == 0 && grid[n-1][i] == 1) {
                dfs(n-1, i, vis, grid, n, m);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cnt += grid[i][j];
            }
        }
        return cnt;
    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, int n, int m) {

        vis[row][col] = 1;
        grid[row][col] = 0;
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};
        for(int i = 0; i < 4; i++) {
            int x = row + r[i];
            int y = col + c[i];
            if(x >= 0 && x < n && y >= 0 && y < m && vis[x][y] == 0 && grid[x][y] == 1) {
                grid[x][y] = 0;
                dfs(x, y, vis, grid, n, m);
            }
        }
    }
}


Time Complexity = O(n*m)
Space Complexity = O(n*m)
