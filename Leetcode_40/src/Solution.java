import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, 8, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void combinationSum2(int[] candidate, int m, int target, List<Integer> list, List<List<Integer>> result) {

        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = m; i < candidate.length ; i++) {
            if (i != m && candidate[i] == candidate[i-1]) {
                continue;
            }

            if (candidate[i] <= target) {
                list.add(candidate[i]);
                combinationSum2(candidate, i+1, target - candidate[i], list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
