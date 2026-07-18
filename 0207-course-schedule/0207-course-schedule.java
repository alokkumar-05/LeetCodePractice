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

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for(int i =0 ; i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(adj,visited,inRecursion,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> adj, boolean[] visited,boolean[] inRecursion,int node){
        visited[node]=true;
        inRecursion[node]=true;

        for(int nei : adj.get(node)){
            if(!visited[nei]){
                if(hasCycle(adj,visited,inRecursion,nei)){
                    return true;
                }
            }
            else if(inRecursion[nei]){
                return true;
            }
        }

        inRecursion[node]=false;
        return false;
    }
}