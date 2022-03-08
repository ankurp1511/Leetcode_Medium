public class Solution {

    public static void main(String[] args) {

        double x = 2;
        int n = -2;

        if (n < 0) {
            x = 1/x;
        }

        System.out.println(power(x, n));
    }

    private static double power(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double halfResult = power(x, n/2);

        if (n % 2 == 0) {
            return halfResult * halfResult;
        }
        return halfResult * halfResult * x;
    }
}
