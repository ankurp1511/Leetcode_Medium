public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(quickSelect(nums, 3, 0, nums.length - 1));
    }

    private static int quickSelect(int[] nums, int k, int low, int high) {

        int partition = partition(nums, low, high);

        if (partition == k-1) {
            return nums[k-1];
        } else if (partition < k-1) {
            return quickSelect(nums, k, partition + 1, high);
        } else {
            return quickSelect(nums, k, low, partition - 1);
        }
    }

    private static int partition(int[] nums, int low, int high) {

        int i = low;
        int pivot = nums[high];

        for (int j = low; j <= high-1 ; j++) {

            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
