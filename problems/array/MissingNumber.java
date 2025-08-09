package problems.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = { 3, 0, 1 };
        int result = missingNumberOptimal(array);
        System.out.println(result);
    }

    public static int missingNumberOptimal(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;

    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int sumOfn = nums.length * (nums.length + 1) / 2;

        return sumOfn - sum;

    }
}
