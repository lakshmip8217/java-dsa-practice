package hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubArraysSum {

    public static void main(String[] args) {

//        // Test 1: Simple array with positive numbers
//        int[] nums1 = {1, 1, 1};
//        int k1 = 2;
//        System.out.println("Test 1 Result: " + subarraySum(nums1, k1)); // Expected: 2 ([1,1] and)
//
//        // Test 2: Array containing negative numbers
//        int[] nums2 = {1, -1, 1, 1, 1};
//        int k2 = 2;
//        System.out.println("Test 2 Result: " + subarraySum(nums2, k2)); // Expected: 4
//
//        // Test 3: No valid subarrays exist
//        int[] nums3 = {1, 2, 3};
//        int k3 = 7;
//        System.out.println("Test 3 Result: " + subarraySum(nums3, k3)); // Expected: 0
//        int[] nums4 = { 3, 4};
//        int k4 = 3;
//        System.out.println("Test 4 Result: " + subarraySum(nums4, k4)); // Expected: 1

        int[] nums5 = { 1, 2, 1, 2};
        int k5 = 3;
        System.out.println("Test 5 Result: " + subarraySum(nums5, k5)); // Expected: 1
    }

    /**
     * Time - O(n)
     * Space - O(n) , only in the case of [1, -1, 1, -1, 1, -1...]. Here, the running prefix sum will only ever
     * toggle between 1 and 0. No matter how long the array is (\(n = 1,000,000\)),
     * the HashMap will never hold more than 2 elements. iN THIS CASE O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int currentSum =0;

        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);

        for(int num: nums) {
            currentSum += num;
            if(sumCounts.containsKey(currentSum-k)) {
                count += sumCounts.get(currentSum-k);
            }
            sumCounts.put(currentSum, sumCounts.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
