class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j]=='1') {
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};

        visited[row][col]=true;

        for(int i = 0 ; i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol]=='1'){
                dfs(grid,visited,nrow,ncol);
            }
        }

    }
}