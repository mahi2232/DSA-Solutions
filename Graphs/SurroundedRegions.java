class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, vis, board, n, m);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) {
                dfs(i, m-1, vis, board, n, m);
            }
        }
        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && vis[0][i] == 0) {
                dfs(0, i, vis, board, n, m);
            }
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0) {
                dfs(n-1, i, vis, board, n, m);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, char[][] mat, int n, int m) {
        vis[row][col] = 1;
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};

        for(int i = 0; i < 4; i++) {
            int x = row + r[i];
            int y = col + c[i];

            if(x >= 0 && x < n && y >= 0 && y < m && vis[x][y] == 0 && mat[x][y] == 'O') {
                dfs(x, y, vis, mat, n , m);
            }
        }
    }
}


Time Complexity = O(m*n)
Space Complexity = O(m*n)
