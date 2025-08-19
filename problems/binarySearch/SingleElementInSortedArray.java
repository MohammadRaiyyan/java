package problems.binarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        int result = find(nums);
        System.out.println(result);

    }
    // Using linear search we can check the just previous and just next element is
    // same as the current element we can say it is single element

    static int find(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            // For Safe first access
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
                // For Safe last access
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i]) {
                    return nums[i];
                }
            }

        }

        return -1;
    }
}
