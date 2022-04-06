import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Node {
        char val;
        int row;
        int column;

        public char getVal() {
            return val;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public Node(char val, int row, int column) {
            this.val = val;
            this.row = row;
            this.column = column;
        }
    }

    static int[][] directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0','0'},
                {'1','1','0','1','0','0'},
                {'1','1','0','0','0','0'},
                {'0','0','0','1','0','1'},
                {'0','0','0','0','1','1'}
        };

        int numOfIslands = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i=0; i< grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numOfIslands++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        System.out.println(numOfIslands);
    }

    private static void bfs(int i, int j, char[][] grid, boolean[][] visited) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(grid[i][j], i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] arr: directions) {
                if (node.row + arr[0] >= 0 && node.row + arr[0] < grid.length
                        && node.column + arr[1] >= 0 && node.column + arr[1] < grid[0].length
                        && !visited[node.row + arr[0]][node.column + arr[1]]
                        && grid[node.row + arr[0]][node.column + arr[1]] == '1') {
                    queue.add(new Node(grid[node.row + arr[0]][node.column + arr[1]], node.row + arr[0], node.column + arr[1]));
                    visited[node.row + arr[0]][node.column + arr[1]] = true;
                }
            }
        }
    }
}
