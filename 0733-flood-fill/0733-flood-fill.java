class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        int[][] nImage = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int orgClr = image[sr][sc];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nImage[i][j] = image[i][j];
            }
        }
        bfs(nImage, visited, orgClr, sr, sc, color);
        return nImage;
    }

    private void bfs(int[][] nImage, boolean[][] visited, int orgClr, int row, int col, int color) {
        int n = nImage.length;
        int m = nImage[0].length;

        int[] drow = { 1, 0, -1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;
        nImage[row][col] = color;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol]
                        && nImage[nrow][ncol] == orgClr) {
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                    nImage[nrow][ncol] = color;

                }
            }
        }
    }
}