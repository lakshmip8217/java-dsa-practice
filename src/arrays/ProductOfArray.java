package arrays;

import java.util.Arrays;

public class ProductOfArray {
    public static void main() {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Time O(n)
     * Auxiliary space: O(1) — only prefix, suffix, i, j.
     * Output space: O(n) for result,
     * which normally does not count as extra space because the problem requires returning an array.
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];

        java.util.Arrays.fill(result, 1);
        int prefix = 1, suffix = 1;

        for(int i =0, j= n-1; i<n ; i++, j--) {
            result[i] *= prefix;
            prefix *= nums[i];

            result[j] *= suffix;
            suffix *= nums[j];
        }
        return result;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix (left) products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix (right) products dynamically
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
