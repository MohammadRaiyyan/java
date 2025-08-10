// https://leetcode.com/problems/subarray-sum-equals-k/description/
package problems.array;

import java.util.HashMap;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int result = subArraySumOptimal(arr, 3);
        System.out.println(result);
    }

    static int subArrayBrute(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    count++;
                }
            }

        }
        return count;
    }

    static int subArraySumOptimal(int[] a, int k) {
        int preSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            preSum += a[i];
            int rem = preSum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
