package arrays;

public class FirstMissingNumber {
    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        int n = A.length;

        // 1. Put each number in its right place if possible
        for (int i = 0; i < n; i++) {
            // While the current number is a valid positive integer within range,
            // and it is not already at its correct index position (A[i] - 1)
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                // Swap A[i] with the element at its target index
                int targetIndex = A[i] - 1;
                int temp = A[i];
                A[i] = A[targetIndex];
                A[targetIndex] = temp;
            }
        }

        // 2. Find the first index where the number doesn't match the index + 1
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all numbers from 1 to n are present, the answer is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A)); // Output: 5
    }
}
