package problems.binarySearch;

public class KthMissingNumber {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 7, 11 };
        // {1, 5, 7, 8, 9, 10 }
        System.out.println(find(nums, 5));
    }

    static int find(int[] nums, int k) {
        int ans = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= ans) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
