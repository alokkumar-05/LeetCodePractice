class Solution {

    // Helper class to store coordinates and distance
    private static class Pair {
        int row;
        int col;
        int dis;

        Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Matrix to store distance of nearest 0
        int[][] distanceMat = new int[n][m];

        // Visited matrix to track processed cells
        boolean[][] vis = new boolean[n][m];

        // Queue for BFS traversal
        Queue<Pair> q = new ArrayDeque<>();

        // Push all 0s into the queue as starting points.
        // Each 0 starts BFS with distance 0; its neighbors will have distance +1.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat[row][col] == 0) {
                    q.offer(new Pair(row, col, 0));
                    vis[row][col] = true;
                }
            }
        }

        // Possible 4 directions (down, right, up, left)
        int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        // BFS traversal — process all cells layer by layer
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dis;

            // Assign the distance value to the result matrix
            distanceMat[row][col] = dist;

            // Explore all 4 neighboring directions
            for (int[] dis : directions) {
                int nrow = row + dis[0];
                int ncol = col + dis[1];

                // Check for valid cell and if not visited yet
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true; // Mark as visited to avoid reprocessing
                    q.offer(new Pair(nrow, ncol, dist + 1)); // Enqueue neighbor with distance +1
                }
            }
        }

        // Return final distance matrix
        return distanceMat;
    }
}