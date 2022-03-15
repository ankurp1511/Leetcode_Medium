public class Solution {

    public static void main(String[] args) {

        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }

    public static int findDuplicate(int[] nums) {

        for (int i=0; i< nums.length; i++) {
            if (nums[i] != i + 1) {

                while (true) {
                    if (nums[i] == nums[nums[i]-1]) {
                        break;
                    }
                    swap(nums, i, nums[i]-1);
                }
            }
        }

        for (int j=0; j< nums.length; j++) {
            if (nums[j] != j+1) {
                return nums[j];
            }
        }
        return 0;
    }

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
