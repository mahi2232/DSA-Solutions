class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1; 
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int step = cell[2];
            
            dis[x][y] = step;
            for(int i = 0; i < 4; i++) {
                int row = x + r[i];
                int col = y + c[i];
                if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0) {
                    vis[row][col] = 1;
                    q.add(new int[]{row, col, step+1});
                }
            }
        }
        return dis;
    }
}

Time Complexity = O(m*n)
Space Complexity = O(m*n)
