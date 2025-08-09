package problems.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = { 3, 0, 1 };
        int result = missingNumber(array);
        System.out.println(result);
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
