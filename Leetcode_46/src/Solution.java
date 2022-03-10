import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[]{1,2,3};
        boolean[] visit = new boolean[nums.length];
        permute(nums, new ArrayList<>(), visit, result);
        System.out.println(result);
    }

    private static void permute(int[] nums, List<Integer> list, boolean[] visit,List<List<Integer>> result) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i< nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            permute(nums, list, visit, result);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
