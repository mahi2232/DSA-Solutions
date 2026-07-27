class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        q.add(new int[]{0, 0});
        vis[0][0] = 1;
        int dist = 1;

        while(!q.isEmpty()) {
            for(int i = 0; i < q.size(); i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                if(r == n-1 && c == n-1) return dist;

                int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
                int[] col = {-1, 1, 0, 1, -1, -1, 1, 0};
                for(int j = 0; j < 8; j++) {
                    int x = r + row[j];
                    int y = c + col[j];
                    if(x >= 0 && x < n && y >= 0 && y < n && vis[x][y] == 0 && grid[x][y] == 0) {
                        vis[x][y] = 1;
                        q.add(new int[]{x, y});
                    }
                }

            }
            dist++;
        }

        return -1;
    }
}


Time Complexity = O(n^2)
Space Complexity = O(n^2)
