package problems.binarySearch;

public class SearchInRotatedSortedArrayDuplicate {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        boolean result = search(nums, 0);
        System.out.println(result);
    }

    static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            // If all the three has same number then we will not be able to decide where we
            // can go and and check (left/right)
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }
            // Left part is sorted
            if (nums[start] <= nums[mid]) {
                // Check if target is in range
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
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

        return false;

    }
}
