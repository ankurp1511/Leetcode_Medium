public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        search(nums, 3);
    }

    public static int search(int[] nums, int target) {

        int minElementIndex = searchMinElementIndex(nums, target);

        System.out.println(minElementIndex);
        return minElementIndex;
    }

    private static int searchMinElementIndex(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
