package problems.array;

import java.util.ArrayList;

public class RotateLeftByOne {
    public static void main(String[] args) {
        int d = 18;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        ArrayList<Integer> res = rotateArray2(arr, d);
        System.out.println(res);
    }

    static int[] rotateLeftByOne(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
        return arr;
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int[] temp = new int[k];
        int n = arr.size();
        k = k % n;

        for (int i = 0; i < k; i++) {
            temp[i] = arr.get(i);
        }
        for (int i = k; i < n; i++) {
            arr.set(i - k, arr.get(i));
        }
        for (int i = n - k; i < n; i++) {
            arr.set(i, temp[i - (n - k)]);
        }
        return arr;
    }

    public static void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static ArrayList<Integer> rotateArray2(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k % n;

        // Reverse parts of the array
        reverse(arr, 0, k - 1); // Reverse first k elements
        reverse(arr, k, n - 1); // Reverse remaining
        reverse(arr, 0, n - 1); // Reverse whole array

        return arr;
    }
}
