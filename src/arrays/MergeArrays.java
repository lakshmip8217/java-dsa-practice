package arrays;

import java.util.Arrays;

public class MergeArrays {

    /**
     * Time: O(n log n + m log m)
     * Space: O(n + m)
     * where n = a.length and m = b.length
     */
    public static int[] merge(int[] a, int[] b) {
        int[] mergedList = new int[a.length + b.length];

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, index = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                mergedList[index++] = a[i++];
            } else {
                mergedList[index++] = b[j++];
            }
        }

        while (i < a.length) {
            mergedList[index++] = a[i++];
        }

        while (j < b.length) {
            mergedList[index++] = b[j++];
        }

        return mergedList;
    }
}
