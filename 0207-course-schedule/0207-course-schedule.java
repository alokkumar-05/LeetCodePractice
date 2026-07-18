class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            adj.get(prereq).add(course);
        }

        int[] indegree = new int[numCourses];
        for(int u = 0; u<numCourses;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int nodes =0;

        for(int v=0 ; v<numCourses ; v++){
            if(indegree[v]==0){
                q.add(v);
                nodes++;
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v]==0){
                    q.add(v);
                    nodes++;
                }
            }

        }
       return nodes==numCourses;
    }
}