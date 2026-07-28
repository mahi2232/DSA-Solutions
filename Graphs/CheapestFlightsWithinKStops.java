class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        int stops = 0;

        while(!q.isEmpty() && stops <= k) {
            int size = q.size();
            while(size-- > 0) {
                int[] curr = q.poll();
                for(int[] neighbour : adj.get(curr[0])) {
                    int node = neighbour[0];
                    int price = neighbour[1];
                    if(price + curr[1] < cost[node]) {
                        cost[node] = price + curr[1];
                        q.add(new int[]{node, cost[node]});
                    }
                }
            }
            stops++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}


Time Complexity = O(V + E*K)
Space Complexity = O(V + E)
