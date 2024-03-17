/**
 * @Classname ArrayDeque
 * @Description Deque based on resizable circular array
 * @Date 2024/3/17 11:36
 * @Created by Peng
 */
public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = dec(nextFirst);
        size += 1;

        if (nextLast == nextFirst) {
            resize(2);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = inc(nextLast);
        size += 1;

        if (nextLast == nextFirst) {
            resize(2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int first = getFirstItemIndex();

        while (first != nextLast) {
            System.out.print(items[first] + " ");
            first = inc(first);
        }
    }

    public T removeFirst() {
        if (!isEmpty()) {
            int removedIndex = getFirstItemIndex();

            T removedItem = items[removedIndex];
            items[removedIndex] = null;

            size -= 1;
            nextFirst = inc(nextFirst);

            if (size / items.length <= 0.25) {
                resize(0.5);
            }

            return removedItem;
        }

        return null;
    }

    public T removeLast() {
        if (!isEmpty()) {
            int removedIndex = getLastItemIndex();

            T removeItem = items[removedIndex];
            items[removedIndex] = null;

            size -= 1;
            nextLast = dec(nextLast);

            if (size / items.length <= 0.25) {
                resize(0.5);
            }

            return removeItem;
        }

        return null;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            int ptr = getFirstItemIndex();
            while (index > 0) {
                ptr = inc(ptr);
                index -= 1;
            }

            return items[ptr];
        }
    }


    private int getLastItemIndex() {
        return dec(nextLast);
    }

    private int getFirstItemIndex() {
        return inc(nextFirst);
    }

    private int inc(int index) {
        index += 1;
        if (index >= items.length) {
            index = 0;
        }

        return index;
    }

    private int dec(int index) {
        index -= 1;
        if (index < 0) {
            index = items.length - 1;
        }

        return index;
    }

    private void resize(double factor) {
        T[] temp = (T[]) new Object[(int) (items.length * factor)];

        // copy item of items range [first, last] to new array temp
        int index = 1;
        int first = getFirstItemIndex();
        while (first != nextLast) {
            temp[index] = items[first];
            first = inc(first);
            index += 1;
        }

        items = temp; // items point to resized array
        nextFirst = 0;
        nextLast = size + 1;
    }
}
