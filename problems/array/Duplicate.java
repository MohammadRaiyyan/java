package problems.array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 6 };
        int res = uniqueElementCountOptimal(arr);

        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }

    static int uniqueElementCount(int[] arr) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int num : arr) {
            set.add(num);
        }
        int index = 0;
        for (int num : set) {
            arr[index] = num;
            index++;
        }

        return index;

    }

    static int uniqueElementCountOptimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;

    }
}
