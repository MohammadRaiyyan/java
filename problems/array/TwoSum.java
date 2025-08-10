package problems.array;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSumBetter(nums, target);
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

    static int[] twoSumBetter(int[] a, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int key = target - a[i];
            if (map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i;
                return result;
            } else {
                map.put(a[i], i);
            }
        }
        return result;
    }
}
