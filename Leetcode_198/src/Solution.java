public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,
                235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

        System.out.println(rob(nums, nums.length));
    }

    private static int rob(int[] nums, int n) {

        int m1 = 0;
        int m2 = nums[0];
        int result = 0;

        for (int i = 2; i < n + 1; i++) {

            result = Math.max(nums[i-1] + m1, m2);
            m1 = m2;
            m2 = result;
        }
        return result;
    }
}
