package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeBySign {
    public static void main(String[] args) {
        int[] nums = { 3, 2, -1, 4, -5, 6, -9, -8 };
        int[] result = rearrangeOptimal2(nums);
        System.out.println(Arrays.toString(result));
    }

    static int[] rearrangeBrute(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }

        return nums;
    }

    // For equal number of negative and positive in the array: place on alternate
    // order
    static int[] rearrangeOptimal(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        for (int num : nums) {
            if (num < 0) {
                ans[negIndex] = num;
                negIndex += 2;
            } else {
                ans[posIndex] = num;
                posIndex += 2;
            }
        }

        return ans;
    }
    // 2nd verity for non equal elements fallback to brute solution

    static int[] rearrangeOptimal2(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }

        if (positive.size() > negative.size()) {
            for (int i = 0; i < negative.size(); i++) {
                nums[2 * i] = positive.get(i);
                nums[2 * i + 1] = negative.get(i);
            }
            int index = negative.size() * 2;
            for (int i = negative.size(); i < positive.size(); i++) {
                nums[index] = positive.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < positive.size(); i++) {
                nums[2 * i] = positive.get(i);
                nums[2 * i + 1] = negative.get(i);
            }
            int index = positive.size() * 2;
            for (int i = positive.size(); i < negative.size(); i++) {
                nums[index] = negative.get(i);
                index++;
            }
        }
        return nums;
    }

}
