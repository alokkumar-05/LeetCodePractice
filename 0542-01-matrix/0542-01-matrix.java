class Solution {
    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Pair curr = q.poll();
                int r = curr.r;
                int c = curr.c;

                for (int[] dir : dirs) {
                    int nrow = r + dir[0];
                    int ncol = c + dir[1];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol]) {
                        mat[nrow][ncol] = dist;
                        visited[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}
