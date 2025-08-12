package problems.array;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 0, 2, 1, 0, 2, 1, 2, 0, 1, 2, 1 };
        int[] result = sortOptimal(nums);
        System.out.println(Arrays.toString(result));
    }

    // o(n log n)
    static int[] sortBrute(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // o(n+n+n) = o(3n)
    static int[] sortBetter(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            }
        }
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }

        return nums;
    }

    // Dutch national flag algo->[Red, White, Blue];
    // Low for => 0;
    // Hight for => 2;
    // Mid for current element;
    static int[] sortOptimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
        return nums;
    }

    static void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
}
