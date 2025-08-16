package problems.binarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 6, 7, 9, 10, 12, 13, 14, 17, 18 };
        int target = 7;
        int result = search(nums, target);
        System.out.println(result);
    }

    // find number smallest grater than or equal to target
    static int search(int[] nums, int target) {
        int ans = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
