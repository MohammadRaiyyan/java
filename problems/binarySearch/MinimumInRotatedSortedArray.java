package problems.binarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        int result = findMin(nums);
        System.out.println(result);
    }

    static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            // If first half is sorted
            if (nums[start] <= nums[mid]) {
                // Take minimum
                ans = Math.min(ans, nums[start]);
                // Eliminate left half now
                start = mid + 1;

            } else {
                // Eliminate right half
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }
}
