/**
 * @Classname LinkedListDeque
 * @Description Deque based on Circular Doubly Linked List
 * @Date 2024/3/17 11:36
 * @Created by Peng
 */
public class LinkedListDeque<T> {
    private class Node {
        private T value;
        private Node next;
        private Node prev;

        public Node() {

        }

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Init an empty Deque
     */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Add an item to the head position of the deque
     * @param item
     */
    public void addFirst(T item) {
        // sentinel.next always points to the first node if exists
        Node node = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    /**
     * Add an item to the tail position of the deque
     * @param item
     */
    public void addLast(T item) {
        // sentinel.prev always points to the last node if exists
        Node node = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    /**
     * Check whether a deque is empty or not
     * @return
     */
    public boolean isEmpty() {
        return sentinel.prev == sentinel;
    }

    /**
     * Return the current size of deque
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Print all the elements of the deque from first to last
     */
    public void printDeque() {
        Node pointer = sentinel.next;
        while (pointer != sentinel) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
    }

    /**
     * Remove and return the first element of deque if exists
     * else return null
     * @return
     */
    public T removeFirst() {
        if (!isEmpty()) {
            Node first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size -= 1;

            return first.value;
        }

        return null;
    }

    /**
     * Remove and return the first element of deque if exists
     * else return null
     * @return
     */
    public T removeLast() {
        if (!isEmpty()) {
            Node last = sentinel.prev;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            size -= 1;

            return last.value;
        }

        return null;
    }

    /**
     * Return the index th element in the array if exists else null
     * @param index
     * @return
     */
    public T get(int index) {
        // circular linked list's last node always point to the sentinel node
        Node pointer = sentinel.next;

        while (index > 0 && pointer != sentinel) {
            pointer = pointer.next;
            index -= 1;
        }

        if (pointer == sentinel || index < 0) {
            return null;
        } else {
            return pointer.value;
        }
    }

    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    private T getRecursive(int index, Node rest) {
        if (index >= size || index < 0) {
            return null;
        }

        if (index == 0) {
            return rest.value;
        }

        return getRecursive(index - 1, rest.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }
}
