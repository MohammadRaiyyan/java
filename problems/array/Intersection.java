package problems.array;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 3, 4, 5, 5, 6, 7, 7 };
        int[] b = { 1, 2, 3, 4, 5, 6, 7 };

        List<Integer> result = intersectionOptimal(a, b);
        System.out.println(result);
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

    static List<Integer> intersectionOptimal(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] > a[i]) {
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;
    }
}
