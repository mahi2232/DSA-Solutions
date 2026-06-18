class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
                else if(i==0 && j==0) {
                    obstacleGrid[i][j] = 1;
                }
                else if(i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                }
                else if(j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                }
                else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[n-1][m-1];
    }
}


Time Complexity = O(n2)
Space Complexity = O(1)
