package sliding_windows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestUniqueSubString {
    public static void main(String[] args) {
        String str = "lakshmiprasanna";
        System.out.println("Result 1 (O(n^2)): " + longestSubString(str));
        System.out.println("Result 2 (O(n)): " + uniquelonestSubString(str));
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) - Fixed-size ASCII array
     */
    static int longestSubString(String str) {
        int res = 0;
        int n = str.length();
        String longestRes = "";

        for (int i = 0; i < n; i++) {
            // FIX: Reset the visited tracking array for every new starting position
            boolean[] vis = new boolean[128];

            for (int j = i; j < n; j++) {
                char currentChar = str.charAt(j);

                if (vis[currentChar]) {
                    break;
                } else {
                    vis[currentChar] = true;
                    res = Math.max(res, j - i + 1);

                    if (j - i + 1 > longestRes.length()) {
                        longestRes = str.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println("Longest substring found (O(n^2)): " + longestRes);
        return res;
    }

    /**
     * Sliding Window Protocol
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     */
    static String uniquelonestSubString(String str) {
        HashSet<Character> vis = new HashSet<>();
        int left = 0, right = 0;
        String longestRes = "";

        // FIX: Replaced incomplete loop and added sliding window bounds
        while (right < str.length()) {
            char rightChar = str.charAt(right);

            while (vis.contains(rightChar)) {
                vis.remove(str.charAt(left));
                left++;
            }

            vis.add(rightChar);

            // Track the actual longest string window
            if ((right - left + 1) > longestRes.length()) {
                longestRes = str.substring(left, right + 1);
            }

            right++; // FIX: Advance right pointer
        }
        return longestRes; // FIX: Return the completed result string
    }

    /**
     * Time: O(n) — right traverses the string once, and the HashMap lookup/update is O(1) average.
     * Space: O(k) — where k is the number of unique characters stored in the map.
     * Worst case, k = n, so you can also state O(n) worst-case space.
     * @param str
     * @return
     */
    public static String longestSubStringUsingMap(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        String result = "";

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);

            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }

            lastSeen.put(c, right);

            if (right - left + 1 > result.length()) {
                result = str.substring(left, right + 1);
            }
        }

        return result;
    }

}
