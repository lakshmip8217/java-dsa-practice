package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static linkedlist.ReverseLinkedList.printList;

public class MergeLists {
    public static void main() {
//        List<String> list1 = new ArrayList<>(List.of("Apple", "Banana"));
//        List<String> list2 = List.of("Orange", "Mango");
//
//        // Approach 1: Append list2 directly into list1 (modifies list1)
//        list1.addAll(list2);
//
//        // Approach 2: Combine both into a fresh, third list (keeps originals intact)
//        List<String> combinedList = new ArrayList<>(list1);
//        combinedList.addAll(list2);
//        System.out.println(combinedList);
//
//        List<String> mergedList = Stream.concat(list1.stream(), list2.stream()).collect(
//                Collectors.toList());
//        System.out.println(mergedList);

        // --- 1. CREATE INPUT LIST 1: 1 -> 3 -> 5 ---
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // --- 2. CREATE INPUT LIST 2: 2 -> 4 -> 6 ---
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Print original lists
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        // --- 3. RUN THE MERGE ---
        ListNode mergedHead = merge(list1, list2);

        // Print final result
        System.out.print("Merged List: ");
        printList(mergedHead);

    }

    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 !=null) {
            if(list1.val > list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null) {
             current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
}
