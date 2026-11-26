class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        return dfs(adj,visited,source , destination );
    }

    private boolean dfs(List<List<Integer>> adj ,boolean[] visited, int node, int destination){
       visited[node]= true;
       if(node==destination){
        return true;
       }

       for(int nei : adj.get(node)){
          if(!visited[nei]){
            if(dfs(adj,visited,nei , destination)){
                return true;
            }
          }
       }
       return false;
    }
}
