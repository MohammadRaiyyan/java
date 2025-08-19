package problems.binarySearch;

public class SqrtNumbers {
    public static void main(String[] args) {

    }

    // Ln
    static int lnFind(int num, int target) {
        int ans = 1;
        for (int i = 1; i < num; i++) {
            if (i * i <= num) {
                ans = i;
            } else {
                break;
            }
        }

        return ans;
    }

    public int mySqrt(int x) {
        int start = 0, end = x, ans = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= x) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
