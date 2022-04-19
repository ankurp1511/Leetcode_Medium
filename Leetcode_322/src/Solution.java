public class Solution {

    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{1,2,5}, 15));
    }

    private static int coinChange(int[] coins, int amount) {
        return getMinCoins(coins, coins.length, amount, new int[coins.length + 1][amount + 1]);
    }

    private static int getMinCoins(int[] coins, int n, int amount, int[][] t) {

        for (int a = 0; a<= amount; a++) {
            t[0][a] = Integer.MAX_VALUE-1;
        }

        for (int i= 1 ; i < n + 1; i++) {
            for (int j = 1; j < amount + 1 ; j++) {
                if (coins[i-1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]) == 0 ? -1 :
                            Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j] == Integer.MAX_VALUE ? -1 : t[i-1][j];
                }
            }
        }

        return t[n][amount] == Integer.MAX_VALUE-1 ? -1: t[n][amount];
    }
}
