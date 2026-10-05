package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private static class  Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Time - O(1) ou could find elements in O(1) time, but you would have no efficient way to track which
     * element was accessed least recently.
     * Sorting or updating an array/list of keys would take O(n) time.
     * @param key
     * @return
     */
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K,V> node = map.get(key);
        moveToHead(node);
        return  node.value;
    }

    /**
     * Time - O(1)
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            if(map.size() >= capacity) {
                Node<K, V> lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            // Add new node
            addFirst(newNode);
            map.put(key, newNode);
        }
    }
    // Time - O(1)
    // Helper method to shift an existing node to the MRU position (head)
    public void moveToHead(Node<K, V> node) {
        removeNode(node);
        addFirst(node);
    }

    // time - O(1)
    // Helper method to break a node's existing links
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Time - O(1)
    // Helper method to insert a node right after the dummy head
    private void addFirst(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        // 1. Initialize a cac  he with a small capacity of 2
        System.out.println("Initializing LRUCache with capacity = 2...");
        LRUCache<String, Integer> cache = new LRUCache<>(2);

        // 2. Put initial key-value pairs
        System.out.println("\n--- Testing PUT operations ---");
        cache.put("Apple", 10);  // Cache: [Apple:10]
        cache.put("Banana", 20); // Cache: [Banana:20, Apple:10]
        System.out.println("Added Apple (10) and Banana (20).");

        // 3. Test basic GET operations
        System.out.println("\n--- Testing GET operations ---");
        System.out.println("Get Apple: " + cache.get("Apple")); // Returns 10
        // Crucial detail: Getting "Apple" just made it the Most Recently Used item!
        // Cache state is now: [Apple:10, Banana:20]

        // 4. Trigger eviction by adding a 3rd item
        System.out.println("\n--- Testing EVICTION (Exceeding capacity) ---");
        System.out.println("Adding Cherry (30)...");
        cache.put("Cherry", 30);
        // Capacity is 2. Since "Apple" was accessed recently, "Banana" is the LRU.
        // "Banana" should be automatically evicted. Cache state: [Cherry:30, Apple:10]

        // 5. Verify the state of elements
        System.out.println("\n--- Checking Cache State ---");
        System.out.println("Get Banana (Should be null/evicted): " + cache.get("Banana"));
        System.out.println("Get Apple (Should be 10): " + cache.get("Apple"));
        System.out.println("Get Cherry (Should be 30): " + cache.get("Cherry"));

        // 6. Test updating an existing key
        System.out.println("\n--- Testing UPDATE operation ---");
        System.out.println("Updating Apple value to 99...");
        cache.put("Apple", 99);
        System.out.println("Get Apple (Should be 99): " + cache.get("Apple"));
    }
}
