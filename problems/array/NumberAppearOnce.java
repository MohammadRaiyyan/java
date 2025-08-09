package problems.array;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearOnce {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4 };
        int result = appearOnceOptimal(nums);
        System.out.println(result);
    }

    static int appearOnceOptimal(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    static int appearOnceBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    static int appearOnceBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return 0;
    }
}
