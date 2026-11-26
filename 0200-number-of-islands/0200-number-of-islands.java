class Solution {
    class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                    visited[nrow][ncol]=true;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
    }
}