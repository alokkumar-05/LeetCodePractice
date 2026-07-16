class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces=0;

        for(int i =0; i<n ; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node){
        for(int i = 0 ; i<isConnected.length;i++){
            if(isConnected[node][i]==1 && !visited[i]){
                visited[i]=true;
                dfs(isConnected, visited, i);
            }
        }
    }

}