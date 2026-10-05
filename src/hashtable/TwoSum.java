package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    void main() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        /**
         * Bruteforce - O(n^2) time complexity | O(1) space complexity
         */
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (complement == arr[j]) {
                    System.out.println("Brute Force Pair: " + i + " -> " + j);
                }
            }
        }
        /**
         * with single pass using HashMap
         * time complexity O(n) space complexity O(n) - trying to store each element in the array
         */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++) {
            int complement = target - arr[i];
            if(map.containsKey(complement)) {
               IO.println(map.get(complement) + "--"+ i);
            }
            map.put(arr[i], i);
        }
    }
}
