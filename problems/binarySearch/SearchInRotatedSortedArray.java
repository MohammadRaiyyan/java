package problems.binarySearch;

// http://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1738500750/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int result = search(nums, 1);
        System.out.println(result);
    }

    // Brute force is to find it using linear search o(n)
    // We will be searching it using binary search o(log n)
    // 1. Identity the sorted half.
    // 2. Check if the target lies in the sorted half.
    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Identify which portion is sorted
            // Is Left sorted
            if (nums[start] <= nums[mid]) {
                // Is target lyse between start and end?
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // If target lyse between end and mid
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
