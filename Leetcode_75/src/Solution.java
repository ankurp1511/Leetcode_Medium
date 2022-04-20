import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        sortColors(new int[]{1,2,0});
    }

    public static void sortColors(int[] nums) {

        int i=0, j=0, k = nums.length - 1;

        while (j <= k) {

            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }
            else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            }
            else {
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
