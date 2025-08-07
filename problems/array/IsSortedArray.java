package problems.array;

public class IsSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 8, 5, 6, 7 };
        boolean res = isSorted(arr);
        System.out.println(res);
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
