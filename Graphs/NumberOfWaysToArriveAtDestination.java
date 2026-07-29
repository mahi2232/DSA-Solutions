class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        int mod = (int) (1e9 + 7);

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int)curr[1];
            if(d > dist[node]) continue;
            for(int[] neighbour : graph.get(node)) {
                int nextNode = neighbour[0];
                int time = neighbour[1];
                if(dist[node] + time < dist[nextNode]) {
                    dist[nextNode] = dist[node] + time;
                    ways[nextNode] = ways[node];
                    pq.add(new long[]{dist[nextNode], nextNode});
                }
                else if(dist[node] + time == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
    }
}

Time Complxity = O(elogv)
Space Complexity = O(v+e)
