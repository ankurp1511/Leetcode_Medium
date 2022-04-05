import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{
                {0,2},{1,2},{2,0}
        };

        List<List<Integer>> adjList = new ArrayList<>();

        int numCourses = 3;
        for (int k = 0; k < numCourses ; k++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr: prerequisites) {

            if (!adjList.get(arr[1]).isEmpty()) {
                adjList.get(arr[1]).addAll(Collections.singletonList(arr[0]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                adjList.set(arr[1], list);
            }
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];

        System.out.println(checkIfCyclic(adjList, visited, dfsVisited, numCourses));
    }

    private static boolean checkIfCyclic(List<List<Integer>> adjList, boolean[] visited, boolean[] dfsVisited, int N) {

        for (int i =0; i<N; i++) {
            if (!visited[i]) {
                if(dfs(i ,adjList, visited, dfsVisited)) {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] dfsVisited) {

        visited[node] = true;
        dfsVisited[node] = true;

        for(Integer num: adjList.get(node)) {
            if (!visited[num]) {
                if (dfs(num, adjList, visited, dfsVisited)) {
                    return true;
                }
            } else if (visited[num] && dfsVisited[num]) {
                return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}
