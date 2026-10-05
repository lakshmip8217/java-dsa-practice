package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDequeue<T> {
    private Deque<T> stack;
    StackUsingDequeue() {
        this.stack = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    /**
     * Time - O(1) amortized
     */
    public void push(T val) {
       stack.push(val);
    }

    /**
     * Time - O(1)
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();
    }

    /**
     * Time - O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

}
