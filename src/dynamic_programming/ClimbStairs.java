package dynamic_programming;

public class ClimbStairs {
    public static void main() {
        // Test Cases: [Input n] -> Expected Output
//        int[] testCases = {1, 2, 3, 4, 5, 45};
//        int[] expected = {1, 2, 3, 5, 8, 1836311903};
//
//        System.out.println("--- Running Tests ---");
//        for (int i = 0; i < testCases.length; i++) {
//            int input = testCases[i];
//            int result = climbStairs(input);
//            boolean passed = result == expected[i];
//
//            System.out.printf("n = %-2d | Expected: %-10d | Got: %-10d | Result: %s\n",
//                    input, expected[i], result, passed ? "✅ PASSED" : "❌ FAILED");
//        }

        System.out.println(climbStairs(5));
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev1 = 1, prev2 = 1;
        for (int i=2; i<=n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
