package problems.binarySearch;

public class NthRootOfM {
    public static void main(String[] args) {
        int m = 16, n = 2;
        System.out.println(nthRoot(m, n)); // prints 4

        m = 27;
        n = 3;
        System.out.println(nthRoot(m, n)); // prints 3

        System.out.println(NthRoot(3, 27)); // 3
        System.out.println(NthRoot(4, 69)); // -1
    }

    public static int nthRoot(int m, int n) {
        for (int x = 1; x <= m; x++) {
            long power = 1;
            for (int i = 0; i < n; i++) {
                power *= x;
                if (power > m)
                    break;
            }

            if (power == m)
                return x;
            if (power > m)
                break;
        }
        return -1;
    }

    public static int NthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long power = power(mid, n);

            if (power == m)
                return (int) mid;
            else if (power < m)
                start = (int) mid + 1;
            else
                end = (int) mid - 1;
        }

        return -1;
    }

    static long power(long base, int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE)
                break;
        }
        return result;
    }
}
