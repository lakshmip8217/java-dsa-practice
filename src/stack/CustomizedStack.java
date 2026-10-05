package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * All operations takes O(1) time
 * @param <T>
 */
public class CustomizedStack<T> {
    private int capacity;
    private T[] array;
    private int top;
    @SuppressWarnings("unchecked")
    CustomizedStack(int size) {
        this.capacity = size;
        this.array = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.capacity -1 == top;
    }

    public void push(T val) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        array[top] = val;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is full");
        }
        T latestElement = array[top];
        top = top -1;
        return latestElement;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        }
        return array[top];
    }
}
