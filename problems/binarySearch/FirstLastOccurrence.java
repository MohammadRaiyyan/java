package problems.binarySearch;

import java.util.Arrays;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 6, 8, 8, 8, 11, 13 };
        int[] result = findOptimal(nums, 13);
        System.out.println(Arrays.toString(result));
    }

    static int[] findBrute(int[] nums, int target) {
        int[] result = { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }

    static int[] findOptimal(int[] nums, int target) {
        int lbIdx = LowerBound.search(nums, target);
        int ubIdx = UpperBound.search(nums, target);

        int[] result = { -1, -1 };
        // If lbIdx is pointing to hypothetical index which is outside of the elements
        // and if it does'nt find the actual target then it means number is not present
        // in the list
        // Upper bound gives the index of next element of the target element
        // Lower bound gives the index of the target element or its next element index
        if (lbIdx == nums.length || nums[lbIdx] != target) {
            return result;
        } else {
            result[0] = lbIdx;
            result[1] = ubIdx - 1;
        }
        return result;
    }
}
