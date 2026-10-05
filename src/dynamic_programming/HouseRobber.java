package dynamic_programming;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.print(rob(new int[]{1,2,3}));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev1 = 0, prev2 = 0;

        for(int num:nums) {
            int current = Math.max(prev1, num+ prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int rob1(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
