package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {

    public static void main() {

    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visistedNodes = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if(visistedNodes.contains(current)) {
                return true;
            }
            visistedNodes.add(current);
            current = current.next;
        }
        return false;
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
