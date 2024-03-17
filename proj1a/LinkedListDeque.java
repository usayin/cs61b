/**
 * @Classname LinkedListDeque
 * @Description Deque based on Circular Doubly Linked List
 * @Date 2024/3/17 11:36
 * @Created by Peng
 */
public class LinkedListDeque<T> {
    private static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node() {}

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> sentinel;
    private int size;

    /**
     * Init an empty Deque
     */
    public LinkedListDeque() {
        sentinel = new Node<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * APIs which a Deque should support
     */

    /**
     * Add an item to the head position of the deque
     * @param item
     */
    public void addFirst(T item) {
        // sentinel.next always points to the first node if exists
        Node<T> node = new Node<>(item, sentinel.next, sentinel);
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
        Node<T> node = new Node<>(item, sentinel, sentinel.prev);
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
        Node<T> pointer = sentinel.next;
        while (pointer != sentinel) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
    }

    /**
     * Remove and return the first element of deque if exists else return null
     * @return
     */
    public T removeFirst() {
        if (!isEmpty()) {
            Node<T> first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size -= 1;

            return first.value;
        }

        return null;
    }

    /**
     * Remove and return the first element of deque if exists else return null
     * @return
     */
    public T removeLast() {
        if (!isEmpty()) {
            Node<T> last = sentinel.prev;
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
        Node<T> pointer = sentinel.next;

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

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        deque.addFirst(10);
        deque.addFirst(1);
        deque.addFirst(12);
        deque.addLast(12);
        deque.removeFirst();
        deque.removeFirst();

        deque.printDeque();
    }
}
