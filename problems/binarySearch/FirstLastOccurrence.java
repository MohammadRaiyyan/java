package problems.binarySearch;

import java.util.Arrays;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 6, 8, 8, 8, 11, 13 };
        int[] result = findOptimal(nums, 3);
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

    static int[] findBetter(int[] nums, int target) {
        int lbIdx = LowerBound.search(nums, target);
        // If lbIdx is pointing to hypothetical index which is outside of the elements
        // and if it does'nt find the actual target then it means number is not present
        // in the list
        // Upper bound gives the index of next element of the target element
        // Lower bound gives the index of the target element or its next element index
        if (lbIdx == nums.length || nums[lbIdx] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { lbIdx, UpperBound.search(nums, target) - 1 };
    }

    static int[] findOptimal(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        if (first == -1)
            return new int[] { -1, -1 };

        return new int[] { first, binarySearch(nums, target, false) };
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
