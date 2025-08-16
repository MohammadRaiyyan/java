package problems.binarySearch;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 6, 7, 9, 10, 12, 13, 14, 17, 18 };
        int target = 19;
        int result = searchCeil(nums, target);
        System.out.println(result);
    }

    // Floor: find number largest less than or equal to target
    static int searchFloor(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                ans = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // Ceil: find number largest greater than or equal to target (lower bound)
    static int searchCeil(int[] nums, int target) {
        int ans = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                ans = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
