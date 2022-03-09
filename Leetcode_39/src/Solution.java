import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<List<Integer>> answer = new ArrayList<>();
        combinationSum(new int[]{2}, 0, 1, new ArrayList<>(), answer);
        System.out.println(answer);
    }

    private static void combinationSum(int[] arr, int m, int sum, List<Integer> list, List<List<Integer>> answer) {

        if (sum <= 0) {
            if (sum == 0) {
                answer.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = m; i < arr.length ; i++) {

            if (arr[i] <= sum) {
                list.add(arr[i]);
                combinationSum(arr, i, sum - arr[i], list, answer);
                list.remove(list.size() - 1);
            }
        }
    }
}
