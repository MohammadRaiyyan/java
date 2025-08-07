package problems.array;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] a = { 4, 2, 7, 5, 1, 3 };
        int n = 6;
    }

    static int secondLargestBrute(int[] arr, int n) {
        Arrays.sort(arr);
        int largest = arr[n - 1];
        int secondLargest = arr[n - 2];
        for (int i = n - 2; i < arr.length; i--) {
            if (arr[i] != largest && arr[i] < largest) {
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    static int secondLargestOptimal(int[] arr, int n) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    // { 4, 2, 7, 5, 1, 3 }
    // smallest = 4; sSmallest = infinity;
    // 1: arr[i] = 2; 2 < smallest = true;
    // smallest = 2; sSmallest = 4;
    // 2: arr[i] = 7; 7 < smallest = false; else 7 != smallest = true; 7 < sSmallest
    // = false;
    // smallest = 2; sSmallest = 4;
    // 3: arr[i] = 5; 5 < smallest = false; else 5 != smallest = true; 5 < sSmallest
    // = false;
    // smallest = 2; sSmallest = 4;
    // 4: arr[i] = 1; 1 < smallest = true;
    // smallest = 1; sSmallest = 2;
    // 5: arr[i] = 3; 3 < smallest = false; else 3 != smallest = true; 3 < sSmallest
    // = false;
    static int secondSmallest(int[] arr, int n) {
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] != smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }
}
