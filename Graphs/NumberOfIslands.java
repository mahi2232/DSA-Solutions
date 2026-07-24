class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    cnt++;
                    dfs(i, j, grid, vis, n, m);
                }
            }
        }
        return cnt;
    }

    private void dfs(int r, int c, char[][] grid, int[][] vis, int n, int m) {
        vis[r][c] = 1;
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};
        for(int i = 0; i < 4; i++) {
            int x = r + row[i];
            int y = c + col[i];
            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1' && vis[x][y] == 0) {
                dfs(x, y, grid, vis, n, m);
            }
        }
    }
}

Time Complexity = O(n*m)
Space Complexity = O(n*m)
