package hashtable;

public class MaxProfit {
    void main() {
        // Case 1: Standard case (Buy at 1, Sell at 6 -> Profit = 5)
        int[] case1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Case 1 Profit: " + maxProfit(case1)); // Output: 5

        // Case 2: Monotonically decreasing (Prices drop daily -> Profit = 0)
        int[] case2 = {7, 6, 4, 3, 1};
        System.out.println("Case 2 Profit: " + maxProfit(case2)); // Output: 0

        // Case 3: Flat prices (No change -> Profit = 0)
        int[] case3 = {3, 3, 3, 3, 3};
        System.out.println("Case 3 Profit: " + maxProfit(case3)); // Output: 0

        // Case 4: Lowest price on the last day (Can't buy and sell on same day -> Profit = 2)
        int[] case4 = {2, 4, 1};
        System.out.println("Case 4 Profit: " + maxProfit(case4)); // Output: 2

        // Case 5: Single day / Empty array (Edge cases -> Profit = 0)
        int[] case5 = {5};
        System.out.println("Case 5 Profit: " + maxProfit(case5)); // Output: 0
    }

    /**
     * Time Complexity: O(n) because it loops through the array one time.
     * Space Complexity: O(1) because it only uses two variables.
     * @param values
     * @return
     */
    public static int maxProfit(int[] values) {
        int minval = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: values) {
            if(price < minval) {
                minval = price;
            } else {
                maxProfit = Math.max(maxProfit, price-minval);
            }
        }
        return maxProfit;
    }
}
