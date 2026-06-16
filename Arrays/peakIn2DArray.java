BRUTE FORCE:
  Time Complexity = O(n2 * (n*m))
  Space Complexity = O(1)

  class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int up = (i > 0) ? mat[i-1][j] : Integer.MIN_VALUE;
                int down = (i < n-1) ? mat[i+1][j] : Integer.MIN_VALUE;
                int left = (j > 0) ? mat[i][j-1] : Integer.MIN_VALUE;
                int right = (j < m-1) ? mat[i][j+1] : Integer.MIN_VALUE;

                if(mat[i][j] >= up && mat[i][j] >= down && mat[i][j] >= right && mat[i][j] >= left) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}


OPTIMAL SOLUTION:
  Time Complexity = 
  Space Complexity =

  class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int s = 0;
        int e = m-1;

        while(s <= e) {
            int mid = (s + e)/2;
            int row = findMax(n, mid, mat);
            int left = (mid > 0) ? mat[row][mid-1] : -1;
            int right = (mid < m-1) ? mat[row][mid+1] : -1;

            if(mat[row][mid] >= left && mat[row][mid] >= right) {
                return new int[]{row, mid};
            }
            else if(left > mat[row][mid]) {
                e = mid -1;
            }
            else {
                s = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int findMax(int n, int col, int[][] mat) {
        int max = -1;
        int idx = -1;

        for(int i = 0; i < n; i++) {
            if(mat[i][col] > max) {
                max = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
}
