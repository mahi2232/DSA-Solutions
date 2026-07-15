class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = image;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if(image[sr][sc] == color) {
            return image;
        }
        int init = visited[sr][sc];
        visited[sr][sc] = color;
        q.offer(new int[]{sr, sc});

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] d : dir) {
                    int i = x + d[0];
                    int j = y + d[1];
                    if(i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == init) {
                        visited[i][j] = color;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        return visited;
    }
}


Time Complexity = O(m*n)
Space Complexity = O(m*n)
