package problems.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveAllZeros {
    public static void main(String[] args) {
        int[] numbers = { 5, 8, 0, 4, 3, 1 };
        int[] res = moveOptimal(numbers);
        System.out.println(Arrays.toString(res));
    }

    static int[] move(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                temp.add(arr[j]);
            }
        }
        int tempSize = temp.size();
        for (int j = 0; j < tempSize; j++) {
            arr[j] = temp.get(j);
        }
        for (int j = tempSize; j < arr.length; j++) {
            arr[j] = 0;
        }
        return arr;
    }

    static int[] moveOptimal(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return arr;
        }
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        return arr;
    }
}
