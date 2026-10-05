package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {

    /**
     * Time Complexity O(n logn)
     * Space Complexity - O(1)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        // Sort the array using a custom lambda comparator
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB); // Ascending order
        });

        // Return the first K elements
        return Arrays.copyOfRange(points, 0, k);
    }


    /**
     * Time O(n log k)
     * Space O(k)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosestHeap(int[][] points, int k) {
        // Create a Max-Heap. Sort by distance in descending order (b - a).
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA);
        });

        for (int[] point : points) {
            maxHeap.add(point);
            // If the heap exceeds size K, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Gather results from the heap
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;
    }
}
