package problems.binarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        int result = singleNonDuplicate(nums);
        System.out.println(result);

    }
    // Using linear search we can check the just previous and just next element is
    // same as the current element we can say it is single element

    static int find(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            // For Safe first access
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
                // For Safe last access
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i]) {
                    return nums[i];
                }
            }

        }

        return -1;
    }

    public static int singleNonDuplicate(int[] arr) {
        int start = 1, end = arr.length - 2;
        // If only one element return that as single element
        if (arr.length == 1)
            return arr[0];
        // If first element is not equal to start element then first element is single
        // element
        if (arr[0] != arr[start]) {
            return arr[0];
        }
        // If last element is not equal to end element then its a single single element
        if (arr[arr.length - 1] != arr[end]) {
            return arr[arr.length - 1];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            // If previous and next element is not same which is on mid then its a single
            // element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } // 0 1 2 3 4 5 6 7
              // (even,odd) : [even,odd,even,odd,even,odd,even,odd]
              // If mid is odd and previous element equal to mid then eliminate left part
              // OR
              // If mid is even and next element equal to mid then eliminate left part

            if ((mid % 2 == 1 && arr[mid - 1] == arr[mid]) || (mid % 2 == 0 && arr[mid + 1] == arr[mid])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
