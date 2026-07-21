class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Reverse graph
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                adj.get(v).add(u);
            }
        }

        int[] outDegree = new int[V];
        for(int i = 0 ; i<V;i++){
            for(int edges : adj.get(i)){
                outDegree[edges]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<V;i++){
            if(outDegree[i]==0){
                res.add(i);
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei : adj.get(curr)){
                outDegree[nei]--;
                if(outDegree[nei]==0){
                    res.add(nei);
                    q.offer(nei);
                }
            }
        }

     Collections.sort(res);
     return res;

    }
}