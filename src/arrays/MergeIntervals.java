package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    void main() {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals(input);

        System.out.println("Merged intervals: " + Arrays.deepToString(result));

    }

    /**
     * Time Complexity: \(O(n \log n)\) because the algorithm must sort the data first.
     * Scanning through the sorted list takes linear O(n) time.
     * Space Complexity: O(n) in the worst case to hold the merged output list
     * @param intervals
     * @return
     */
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
