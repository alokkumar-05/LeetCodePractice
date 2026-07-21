class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] outDegree = new int[n];
        for (int i = 0; i < n; i++) {
            outDegree[i] = graph[i].length;

            for (int nei : graph[i]) {
                adj.get(nei).add(i);
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int parent : adj.get(node)) {
                outDegree[parent]--;
                if (outDegree[parent] == 0) {
                    q.offer(parent);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}