package problems.array;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = { 2, 3, 1, 8, 9, 6, 7 };
        int result = findLargestBrute(numbers);
        System.out.println(result);
    }

    static int findLargestBrute(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    static int findLargestOptimal(int[] arr) {
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}
