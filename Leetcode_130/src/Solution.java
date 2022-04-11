public class Solution {

    static int[][] directions = new int[][]{
            {-1,0},{1,0},{0,-1},{0,1}
    };

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };

        solve(board);
        System.out.println(board);
    }

    public static void solve(char[][] board) {

        if (board.length<=2 || board[0].length<=2) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length - 1, board);
        }

        for (int j = 1 ; j<= board[0].length-2; j++) {
            dfs(0, j, board);
            dfs(board.length - 1, j, board);
        }

        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[0].length; b++) {
                if (board[a][b] == 'O') {
                    board[a][b] = 'X';
                }
                if (board[a][b] == 'U') {
                    board[a][b] = 'O';
                }
            }
        }
    }

    private static void dfs(int i, int j, char[][] board) {

        if (i <= board.length - 1 && i >= 0 && j <= board[0].length - 1
                && j >= 0 && board[i][j] == 'O') {
            board[i][j] = 'U';
            for (int[] arr: directions) {
                dfs(i + arr[0], j + arr[1], board);
            }
        }

    }
}
