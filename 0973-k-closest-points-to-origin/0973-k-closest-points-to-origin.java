class Solution {
    class PointData {
        int dist;
        int row;
        int col;

        PointData(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<PointData> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);

        for (int[] point : points) {
            int r = point[0];
            int c = point[1];
            int d = r * r + c* c;

            pq.add(new PointData(d, r, c));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        while(k>0){
            PointData curr = pq.poll();
            res[--k] = new int[]{curr.row , curr.col};
        }
        return res;
    }
}