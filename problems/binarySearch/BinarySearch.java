package problems.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 0;
        // int result = search(nums, target);
        int result = searchRecursive(nums, target, 0, nums.length - 1);
        System.out.println(result);
    }

    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int searchRecursive(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (target > nums[mid]) {
            return searchRecursive(nums, target, mid + 1, end);
        }
        return searchRecursive(nums, target, start, mid - 1);
    }
}
