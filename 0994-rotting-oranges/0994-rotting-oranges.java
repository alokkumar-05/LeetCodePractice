class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }
        int mTime = 0;
        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();

            boolean isChanged = false;

            for (int j = 0; j < size; j++) {

                Pair curr = q.poll();
                int r = curr.row;
                int c = curr.col;

                for (int i = 0; i < 4; i++) {
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                        fresh--;
                        grid[nrow][ncol] = 2;
                        isChanged = true;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }

            if (isChanged) {
                mTime++;
            }

        }

        if (fresh != 0) {
            return -1;
        }
        return mTime;
    }
}