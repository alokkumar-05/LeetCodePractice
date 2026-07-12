class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] isConnected = new boolean[n][m];
        int islands = 0;

        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<m;j++){
                if(grid[i][j]=='1' && !isConnected[i][j]){
                    dfs(grid,isConnected,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] isConnected, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >=m) {
            return;
        }
        if (grid[row][col] == '0'|| isConnected[row][col]) {
            return;
        }
        isConnected[row][col] = true;

        dfs(grid, isConnected, row + 1, col);
        dfs(grid, isConnected, row - 1, col);
        dfs(grid, isConnected, row, col + 1);
        dfs(grid, isConnected, row, col - 1);
    }
}