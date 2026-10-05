package arrays;

import java.util.*;

public class KFrequentNumbers {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test 1 (Expected: [1, 2]): "
                + Arrays.toString(topKFrequent(nums1, k1)));

        // Test Case 2: All Elements Unique (Tie)
        int[] nums2 = {4, 5, 6, 7};
        int k2 = 2;
        System.out.println("Test 2 (Expected: Any 2 unique elements): "
                + Arrays.toString(topKFrequent(nums2, k2)));

        // Test Case 3: Single Element
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("Test 3 (Expected: [1]): "
                + Arrays.toString(topKFrequent(nums3, k3)));

        // Test Case 4: Negative Numbers Included
        int[] nums4 = {-1, -1, 2, -1, 2, 0};
        int k4 = 2;
        System.out.println("Test 4 (Expected: [-1, 2]): "
                + Arrays.toString(topKFrequent(nums4, k4)));

        // Test Case 5: K equals Total Unique Elements
        int[] nums5 = {1, 2, 3, 1, 2, 3};
        int k5 = 3;
        System.out.println("Test 5 (Expected: [1, 2, 3] in any order): "
                + Arrays.toString(topKFrequent(nums5, k5)));
    }

    /**
     * Time - O(n log k)
     * Space - O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // store the count of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // store only top k frequent numbers in minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int n: map.keySet()) {
            pq.offer(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        for(int i= k-1; i >=0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : freqMap.keySet()) {
            int frequency = freqMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // Step 3: Collect top K elements by scanning buckets backwards
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
