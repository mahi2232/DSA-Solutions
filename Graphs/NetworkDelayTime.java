class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] time : times) {
            adj.get(time[0]-1).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        pq.add(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if(d > dist[node-1]) continue;
            for(int[] neighbour : adj.get(node-1)) {
                int time = d + neighbour[1];
                int neighbourNode = neighbour[0];
                if(time < dist[neighbourNode-1]) {
                    dist[neighbourNode-1] = time;
                    pq.add(new int[]{time, neighbourNode});
                }
            }
        }
        int max = 0;
        for(int t : dist) {
            max = Math.max(max, t);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

Time Complexity = O(elogn)
Space Complexity = O(v+e)
