class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int d = node[0];
            int r = node[1];
            int c = node[2];
            if(r == n-1 && c == m-1) return d;
            for(int i = 0; i < 4; i++) {
                int x = r + dr[i];
                int y = c + dc[i];
                if(x >= 0 && x < n && y >= 0 && y < m) {
                    int effort = Math.max(Math.abs(heights[r][c] - heights[x][y]), d);
                    if(effort < dist[x][y]) {
                        dist[x][y] = effort;
                        pq.add(new int[]{effort, x, y});
                    }
                }
            }
        }
        return 0;
    }
}

Time Complexity = O(m×nlog(m×n))
Space Complexity = O(m*n)
