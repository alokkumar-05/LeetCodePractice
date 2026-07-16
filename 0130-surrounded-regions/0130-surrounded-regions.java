class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    dfs(board, visited, i, j);
                }
            }
        }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]&& board[i][j] == 'O') {
                    board[i][j]='X';
                }
            }
        }

    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col) {
        int n = board.length;
        int m = board[0].length;

        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(board, visited, nrow, ncol);
            }

        }
    }
}
