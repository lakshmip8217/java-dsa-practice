package hashtable;

import java.util.*;

public class GroupAnagrams {
    void main() {
// Test Case 1: Standard input
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1 Input:  " + Arrays.toString(test1));
        System.out.println("Test 1 Result: " + groupAnagrams(test1));
        System.out.println("Test 1 Result: " + groupAnagramsNoSorting(test1));
        System.out.println();

        // Test Case 2: Duplicate words
        String[] test2 = {"cat", "cat", "tac"};
        System.out.println("Test 2 Input:  " + Arrays.toString(test2));
        System.out.println("Test 2 Result: " + groupAnagrams(test2));
        System.out.println("Test 2 Result: " + groupAnagramsNoSorting(test2));
        System.out.println();

        // Test Case 3: Empty and single strings
        // Test Case 3: Empty and single strings
        String[] test3 = {"", "a", "b", "a"};
        System.out.println("Test 3 Input:  " + Arrays.toString(test3));
        System.out.println("Test 3 Result: " + groupAnagrams(test3));
        System.out.println("Test 3 Result: " + groupAnagramsNoSorting(test3));
    }

    /**
     * The Time Factor (\(K \log K\)): You are sorting the characters inside each individual word,
     * not the array of words itself. If K is the length of the longest word, sorting it takes \(O(K \log K)\) time.
     * Since you repeat this for all N words, the total time is \(O(N \cdot K \log K)\).
     * It would only be \(O(N \log N)\) if you were sorting the entire list of words alphabetically.
     * The Space Factor (N ⋅ K): The space is \(O(N \cdot K)\) because your HashMap must store all N words,
     * and each word takes up K characters of memory.
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Base case check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Time complexity: outloop O(n), inner loop counting each character in a word O(k)
     * inner loop key building O(1), Total Time: O( n. O(K+26)), i.e. O( nk)
     * Space complexity: O(n k) n is the total no of strings in the string[] k is the length of each word
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsNoSorting(String[] strs) {
        if(strs == null || strs.length ==0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs) {
            int[] count = new int[26];
            char[] arr = word.toCharArray();
            for(char c: arr) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i: count) {
                sb.append("#").append(i);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
