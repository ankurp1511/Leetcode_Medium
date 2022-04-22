import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Node {
        int row;
        int column;

        public Node (int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static final int[][] directions = new int[][]{
            {0,-1},{0,1},{-1,0},{1,0}
    };

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {2,1,1},{1,1,1},{0,1,2}
        };

        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int minutes = bfs(grid, visited, queue);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    private static int bfs(int[][] grid, boolean[][] visited, Queue<Node> queue) {

        int minutes = 0;
        while (!queue.isEmpty()) {
            boolean added = false;
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                Node node = queue.poll();

                for (int[] arr: directions) {
                    if (node.row + arr[0] >= 0 && node.row + arr[0] < grid.length &&
                            node.column + arr[1] >= 0 && node.column + arr[1] < grid[0].length) {

                        if (grid[node.row + arr[0]][node.column + arr[1]] == 1 &&
                                !visited[node.row + arr[0]][node.column + arr[1]]) {

                            queue.add(new Node(node.row + arr[0], node.column + arr[1]));
                            visited[node.row + arr[0]][node.column + arr[1]] = true;
                            added = true;
                        }
                    }
                }
            }
            if (added) {
                minutes++;
            }
        }
        return minutes;
    }
}
