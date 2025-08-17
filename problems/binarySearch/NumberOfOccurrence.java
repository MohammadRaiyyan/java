package problems.binarySearch;

// https://www.naukri.com/code360/problems/occurrence-of-x-in-a-sorted-array_630456?leftPanelTabValue=PROBLEM&count=25&page=1&search=occ&sort_entity=order&sort_order=ASC&customSource=studio_nav
public class NumberOfOccurrence {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3 };
        int result = count(nums, 1);
        System.out.println(result);
    }

    // Find first occ and last occ in between total range is duplicate count
    public static int count(int arr[], int x) {
        int first = binarySearch(arr, x, true);
        if (first == -1)
            return 0;
        return binarySearch(arr, x, false) - first + 1;
    }

    static int binarySearch(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

}
