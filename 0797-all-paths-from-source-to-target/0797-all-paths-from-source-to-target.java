class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();

        dfs(0, graph, currentPath, answer);

        return answer;
        
    }

    public void dfs(int currentNode, int[][]graph, List<Integer>currentPath,List<List<Integer>>answer){

        // add current node into path
        currentPath.add(currentNode);

        int destination =graph.length-1;

        // destination reached
        if(currentNode==destination){
            answer.add(new ArrayList<>(currentPath));
        }

        else{

            // visit neighbour
            for(int neighbour:graph[currentNode]){

                dfs(neighbour,graph,currentPath,answer);
            }
        }

            // backtracking
            currentPath.remove(currentPath.size()-1);
        }
}