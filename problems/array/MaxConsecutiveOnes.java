package problems.array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0, 1 };
        int result = maxConsecutiveOnes(nums);
        System.out.println(result);
    }

    static int maxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);

        return max;
    }
}
