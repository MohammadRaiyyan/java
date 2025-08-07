package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class UnionArrays {
    public static void main(String[] args) {
        int[] arr1 = { 7, 8, 9, 10, 11, 12, 13 };
        int[] arr2 = { 1, 1, 2, 3, 4, 4, 5, 6 };
        int[] result = optimalUnion(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    static int[] union(int[] arr1, int[] arr2) {
        LinkedHashSet<Integer> unionSet = new LinkedHashSet<>();
        // Step 1: Push all the arr1 elements in the set
        for (int e : arr1) {
            unionSet.add(e);
        }
        // Step 2: Push all the arr2 elements in the set
        for (int e : arr2) {
            unionSet.add(e);
        }
        int[] result = new int[unionSet.size()];
        int i = 0;
        for (int e : unionSet) {
            result[i++] = e;
        }
        Arrays.sort(result);
        return result;
    }

    public static int[] optimalUnion(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                addIfNotDuplicate(union, arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                addIfNotDuplicate(union, arr2[j]);
                j++;
            } else {
                // both are equal
                addIfNotDuplicate(union, arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < arr1.length) {
            addIfNotDuplicate(union, arr1[i]);
            i++;
        }

        // Add remaining elements of arr2
        while (j < arr2.length) {
            addIfNotDuplicate(union, arr2[j]);
            j++;
        }

        // Convert list to array
        int[] result = new int[union.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = union.get(k);
        }
        return result;
    }

    private static void addIfNotDuplicate(List<Integer> list, int num) {
        if (list.isEmpty() || list.get(list.size() - 1) != num) {
            list.add(num);
        }
    }
}
