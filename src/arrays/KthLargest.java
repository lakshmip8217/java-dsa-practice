package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {



    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargestMinHeap(nums, 4));
        System.out.println(findKthLargestQuickSelect(nums, 4));
    }

    /**
     * Time - O(n log n)
     * Space - O(1) NOTE: Input array is modified during the sorting
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * Time - O(n log k)
     * Space - O (k)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i: nums) {
            pq.add(i);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestQuickSelect(int[] nums, int k) {
        // The k-th largest element corresponds to the (n - k)-th index in a sorted array
        int targetIndex = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, targetIndex);
    }

    private static int quickselect(int[] nums, int left, int right, int targetIndex) {
        Random random = new Random();
        if (left == right) {
            return nums[left];
        }

        // Pick a random pivot index and partition the array
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        // Check if we found the target index
        if (pivotIndex == targetIndex) {
            return nums[pivotIndex];
        } else if (pivotIndex < targetIndex) {
            // Search the right subarray
            return quickselect(nums, pivotIndex + 1, right, targetIndex);
        } else {
            // Search the left subarray
            return quickselect(nums, left, pivotIndex - 1, targetIndex);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];

        // Move pivot to the end of the current range
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move all smaller elements to the left of storeIndex
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        // Move pivot to its final resting place
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
