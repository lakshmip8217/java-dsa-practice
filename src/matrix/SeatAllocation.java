package matrix;

import java.util.HashMap;
import java.util.Map;

public class SeatAllocation {
    public static int solution(int N, String S) {
        // Map seat letters to column indices for easy tracking
        // Columns: A=0, B=1, C=2, D=3, E=4, F=5, G=6, H=7, J=8, K=9
        Map<Character, Integer> seatMap = new HashMap<>();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        for (int i = 0; i < letters.length; i++) {
            seatMap.put(letters[i], i);
        }

        // Use a set of boolean arrays to track reserved seats per row
        // Using a Map ensures we only allocate memory for rows that have reservations
        Map<Integer, boolean[]> reservedRows = new HashMap<>();

        if (S != null && !S.trim().isEmpty()) {
            String[] reservedSeats = S.split(" ");
            for (String seat : reservedSeats) {
                // Parse row number (could be multiple digits like "12")
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char colLetter = seat.charAt(seat.length() - 1);
                int colIndex = seatMap.get(colLetter);

                // Initialize the row's seating array if not already present
                reservedRows.putIfAbsent(row, new boolean[10]);
                reservedRows.get(row)[colIndex] = true;
            }
        }

        // Total families that can be seated across empty rows
        // Every completely empty row can automatically hold 2 families
        int totalFamilies = (N - reservedRows.size()) * 2;

        // Process rows that contain at least one reservation
        for (boolean[] row : reservedRows.values()) {
            boolean leftFree = !row[0] && !row[1] && !row[2];   // A, B, C
            boolean rightFree = !row[7] && !row[8] && !row[9];  // H, J, K

            boolean midLeftFree = !row[3] && !row[4] && !row[5]; // D, E, F
            boolean midRightFree = !row[4] && !row[5] && !row[6];// E, F, G

            if (leftFree) {
                totalFamilies++;
            }
            if (rightFree) {
                totalFamilies++;
            }

            // Check the middle block. Only 1 family max can fit here per row,
            // even if both sub-blocks are free.
            if (midLeftFree || midRightFree) {
                totalFamilies++;
            }
        }

        return totalFamilies;
    }

    public static void main(String[] args) {

        // Example 1: 2 rows, some reserved seats
        System.out.println(solution(2, "1A 2F 1C")); // Output: 2

        // Example 2: 1 row, completely empty
        System.out.println(solution(1, ""));         // Output: 2
    }
}
