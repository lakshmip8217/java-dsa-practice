package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
// Test Case 1: Standard List
        System.out.print("Test 1 Input:  ");
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        printList(head1);
        System.out.print("Test 1 Output: ");
        printList(reverse(head1));
       // printList(reverseListUsingRecursion(head1));

        System.out.println();

        // Test Case 2: Single Node
        System.out.print("Test 2 Input:  ");
        ListNode head2 = createList(new int[]{42});
        printList(head2);
        System.out.print("Test 2 Output: ");
        printList(reverse(head2));
       // printList(reverseListUsingRecursion(head2));

        System.out.println();

        // Test Case 3: Empty List
        System.out.print("Test 3 Input:  ");
        ListNode head3 = null;
        printList(head3);
        System.out.print("Test 3 Output: ");
        printList(reverse(head3));
       // printList(reverseListUsingRecursion(head3));
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Helper method to build a linked list from an array
    public static ListNode createList(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Time - O(n)
     * Space - O(n) space due to the call stack frames
     * @param head
     * @return
     */
    public static ListNode reverseListUsingRecursion (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}