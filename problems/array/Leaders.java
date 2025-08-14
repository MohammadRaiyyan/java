package problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaders {
    public static void main(String[] args) {
        int[] nums = { 13, 14, 3, 8, 2 };
        List<Integer> ans = getLeadersOptimal(nums);
        System.out.println(ans);
    }
    // Problem statement
    // Given a sequence of numbers. Find all leaders in sequence. An element is a
    // leader if it is strictly greater than all the elements on its right side.

    // Note:
    // 1. Rightmost element is always a leader.

    // 2. The order of elements in the return sequence must be the same as the given
    // sequence
    // Example:
    // The given sequence is 13, 14, 3, 8, 2 .

    // 13 Not a leader because on the right side 14 is greater than 13.

    // 14 lt is a leader because no one greater element in the right side.

    // 3 Not a leader because on the right side 8 are greater than 3.

    // 8 It is a leader because no one greater element on the right side.

    // 2 It is a leader because it is the rightmost element in a sequence.

    // Hence there are 3 leaders in the above sequence which are 14, 8, 2.
    static List<Integer> getLeaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    static List<Integer> getLeadersOptimal(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    // 1299. Replace Elements with Greatest Element on Right Side
    // Easy
    // Given an array arr, replace every element in that array with the greatest
    // element among the elements to its right, and replace the last element with
    // -1.

    // After doing so, return the array.

    // Example 1:

    // Input: arr = [17,18,5,4,6,1]
    // Output: [18,6,6,6,1,-1]
    // Explanation:
    // - index 0 --> the greatest element to the right of index 0 is index 1 (18).
    // - index 1 --> the greatest element to the right of index 1 is index 4 (6).
    // - index 2 --> the greatest element to the right of index 2 is index 4 (6).
    // - index 3 --> the greatest element to the right of index 3 is index 4 (6).
    // - index 4 --> the greatest element to the right of index 4 is index 5 (1).
    // - index 5 --> there are no elements to the right of index 5, so we put -1.
    // Example 2:

    // Input: arr = [400]
    // Output: [-1]
    // Explanation: There are no elements to the right of index 0.
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }
}
