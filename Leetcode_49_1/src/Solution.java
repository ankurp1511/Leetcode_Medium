import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[]{1,1,3};
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        permute(0, nums, new ArrayList<>(), visit, result);
        System.out.println(result);
    }

    private static void permute(int m, int[] nums, List<Integer> list, boolean[] visit,List<List<Integer>> result) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i< nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (list.size() == 0 && i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            permute(m+1, nums, list, visit, result);
            visit[i] = false;
            list.remove(list.size() - 1);
            while (i +1 < nums.length && nums[i] == nums[i+1]) {
                ++i;
            }
        }
    }
}
