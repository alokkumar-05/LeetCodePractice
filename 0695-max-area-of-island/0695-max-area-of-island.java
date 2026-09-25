class Solution {
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int marea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = IslandArea(i, j, vis, grid);
                    marea = Math.max(area, marea);
                }
            }
        }
        return marea;
    }

    private int IslandArea(int r, int c, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c));
        vis[r][c] = true;
        int area = 1;

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + drow[i];
                int nc = curr.c + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1) {
                    q.offer(new Pair(nr, nc));
                    vis[nr][nc] = true;
                    area++;
                }
            }
        }
        return area;
    }
}