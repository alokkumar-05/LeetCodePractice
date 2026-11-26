class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || r > n || c < 0 || c >m) {
            return;
        }

        vis[r][c] = true;

        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                dfs(grid,nrow, ncol,vis);
            }
        }

    }
}