package problems.binarySearch;

public class RotatedArrayCount {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = findRotation(nums);

        System.out.println(result);
    }

    static int findRotation(int[] nums) {
        int start = 0, end = nums.length - 1, index = -1, ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            // If first half is sorted
            if (nums[start] <= nums[mid]) {
                // Take minimum
                if (nums[start] < ans) {
                    ans = nums[start];
                    index = start;
                }
                // Eliminate left half now
                start = mid + 1;

            } else {
                // Eliminate right half

                if (nums[mid] < ans) {
                    ans = nums[mid];
                    index = mid;

                }
                end = mid - 1;
            }
        }
        return index;
    }
}
