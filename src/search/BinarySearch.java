package search;

public class BinarySearch {
    public static void main() {
        // --- Test Case 1: Standard Rotated Array (Target Exists) ---
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = search(nums1, target1);
        System.out.println("Test Case 1 Index: " + result1); // Expected Output: 4

        // --- Test Case 2: Target Does Not Exist ---
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = search(nums2, target2);
        System.out.println("Test Case 2 Index: " + result2); // Expected Output: -1

        // --- Test Case 3: Small Array (Pivot at index 0) ---
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = search(nums3, target3);
        System.out.println("Test Case 3 Index: " + result3); // Expected Output: -1

        // --- Test Case 4: Target at the boundaries ---
        int[] nums4 = {5, 1, 3};
        int target4 = 5;
        int result4 = search(nums4, target4);
        System.out.println("Test Case 4 Index: " + result4); // Expected Output: 0
    }


    /**
     * Time Complexity: (O(log n)).
     * Space Complexity: O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // if mid is the target
            if(nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // Determine if target lies within the sorted left half
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Determine if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Time - O(log n)
     * Space - O(log n)
     */
    public int searchRecursion(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return searchInRotatedArray(nums, 0, nums.length-1, target);
    }

    private int searchInRotatedArray(int[] nums, int left, int right,
                                     int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if( nums[mid] == target) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return searchInRotatedArray(nums, left, mid-1, target);
            } else {
                return searchInRotatedArray(nums, mid+1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return searchInRotatedArray(nums, mid + 1, right, target);
            } else {
                return searchInRotatedArray(nums, left, mid - 1, target);
            }
        }
    }
}
