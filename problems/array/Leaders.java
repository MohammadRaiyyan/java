package problems.array;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    public static void main(String[] args) {
        int[] nums = { 10, 22, 12, 3, 0, 6 };
        List<Integer> ans = getLeaders(nums);
        System.out.println(ans);
    }

    static List<Integer> getLeaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
