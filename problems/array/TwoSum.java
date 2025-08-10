package problems.array;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] result = twoSumBrute(nums, target);
        System.out.println(Arrays.toString(result));
    }

    static int[] twoSumBrute(int[] a, int target) {
        int[] result = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
