package problems.array;

import java.util.Arrays;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        int result = longestConsecutiveSeqBetter(nums);
        System.out.println(result);
    }

    static int longestConsecutiveSeq(int[] nums) {
        // Initially always there will be a one number we can say as largest consecutive
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 1;
            // find if next plus 1 element present in array
            while (ls(nums, x + 1)) {
                x = x + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    static boolean ls(int[] arr, int target) {
        for (int e : arr) {
            if (e == target) {
                return true;
            }
        }
        return false;
    }

    static int longestConsecutiveSeqBetter(int[] nums) {
        // 1. if previous number one less than current number then the current number
        // can
        // be part of sequence else it will become a starter of new sequence.
        // 2. if previous number is same as current number no need to update anything,
        // else reset count
        Arrays.sort(nums);
        int longest = 1, previousSmaller = Integer.MIN_VALUE, count = 0;
        for (int num : nums) {
            if (num - 1 == previousSmaller) {
                count += 1;
                previousSmaller = num;
            } else if (previousSmaller != num) {
                count = 1;
                previousSmaller = num;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
}
