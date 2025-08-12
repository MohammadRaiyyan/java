package problems.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 0, 2, 2, 2, 3, 3, 1, 2, 3 };
        int result = majorityElementOptimal(nums);
        System.out.println("Result: " + result);
    }

    static int majorityElementBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return count;
            }
        }
        return -1;
    }

    static int majorityElementBetter(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        System.out.println(frequencyMap);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getValue();
            }
        }
        return -1;

    }

    // Moore's algorithm
    static int majorityElementOptimal(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int elOccurrence = 0;
        for (int num : nums) {
            if (num == candidate)
                elOccurrence++;
        }
        return (elOccurrence > nums.length / 2) ? candidate : -1;
    }
}
