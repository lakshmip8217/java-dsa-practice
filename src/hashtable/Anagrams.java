package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(isAnagramUsingSorting("anagram", "nagaram")); // true
        System.out.println(isAnagramUsingCounter("anagram", "nagaram")); // true
        System.out.println(isAnagramUsingMap("anagram", "nagaram"));     // true
    }

    /**
     * Time complexity O(n log n)
     * Space complexity O(n)
     * @param s source string
     * @param t target string
     * @return return true if both strings are anagrams otherwise false
     */
    public static boolean isAnagramUsingSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     * Note: Assumes lowercase English letters only.
     * @param s source string
     * @param t target string
     * @return returns true if both strings are anagrams otherwise false
     */
    public static boolean isAnagramUsingCounter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int val : counter) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n) - every letter is stored in the map
     * @param s source
     * @param t target
     * @return return true if anagrams false otherwise
     */
    public static boolean isAnagramUsingMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            // Used getOrDefault to avoid NullPointerException if t has unique letters
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(int value : map.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }
}
