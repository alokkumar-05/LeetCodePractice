class Solution {

    class Pair {
        int node;  
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int node = times[i][1]; 
            int time = times[i][2];

            adj.get(src).add(new Pair(node, time));
        }

        // distance array (1-indexed)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // min-heap based on time
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.time - b.time
        );

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currTime = curr.time;

            // skip outdated entries
            if (currTime > dist[currNode]) continue;

            // relax edges
            for (Pair nei : adj.get(currNode)) {
                int next = nei.node;
                int weight = nei.time;

                int newTime = currTime + weight;

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.offer(new Pair(next, newTime));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}