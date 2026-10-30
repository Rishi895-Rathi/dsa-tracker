class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u].add(new int[]{v, w});
        }
        long[][] dist = new long[n][k + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[2], b[2]));
        dist[0][1] = 0;
        pq.offer(new long[]{0, 1, 0});
        while(!pq.isEmpty()){

            long[] curr = pq.poll();
            int node = (int)curr[0];
            int count = (int)curr[1];
            long cost = curr[2];
            if(cost > dist[node][count]){
                continue;
            }
            if(node == n - 1){
                return (int)cost;
            }

            for(int[] next : adj[node]){
                int v = next[0];
                int wt = next[1];
                int newCount;

                if(labels.charAt(node) == labels.charAt(v)){
                    newCount = count + 1;
                }else{
                    newCount = 1;
                }

                if(newCount > k){
                    continue;
                }

                long newCost = cost + wt;

                if(newCost < dist[v][newCount]){
                    dist[v][newCount] = newCost;

                    pq.offer(new long[]{v, newCount, newCost});
                }
            }
        }

        return -1;
    }
}