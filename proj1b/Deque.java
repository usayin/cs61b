/**
 * @Classname Deque
 * @Description ADT of Deque
 * @Date 2024/3/18 14:48
 * @Created by Peng
 */
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
