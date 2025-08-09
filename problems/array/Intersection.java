package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 3, 4, 5, 5, 6, 7, 7 };
        int[] b = { 1, 2, 3, 3, 4, 5, 5, 6, 7 };

        int[] result = intersectionOptimal(a, b);
        System.out.println(Arrays.toString(result));
    }

    static List<Integer> intersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] && visited[j] == 0) {
                    result.add(a[i]);
                    visited[j] = 1;
                    break;
                }
                if (b[j] > a[i]) {
                    break;
                }
            }
        }

        return result;
    }

    static int[] intersectionOptimal(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : a)
            set1.add(num);

        Set<Integer> result = new HashSet<>();
        for (int num : b) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        int i = 0;
        int[] resultArray = new int[result.size()];
        for (int e : result) {
            resultArray[i] = e;
            i++;
        }
        return resultArray;
    }
}
