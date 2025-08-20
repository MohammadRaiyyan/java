package problems.binarySearch;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        System.out.println(smallestDivisor(nums, 6));
    }

    // Brute
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = max(nums);
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] + i - 1) / i;
            }
            if (sum <= threshold) {
                return i;
            }
        }
        return -1;
    }

    static int max(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int smallestDivisorOptimal(int[] nums, int threshold) {
        int start = 1;
        int end = max(nums);
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(nums, mid, threshold)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    static boolean isFeasible(int[] nums, int d, int th) {
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += (nums[j] + d - 1) / d;
        }
        return sum <= th;
    }
}
