package medical_action_tracking;

// OPTIONAL =========================
public class ArrayQueue<T> {
    private T[] array;
    private static final int DEFAULT_SIZE = 20;
    private int front, rear, size;

    public ArrayQueue() {
        // i love java <3
        array = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }
    public ArrayQueue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException();
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public void enqueue(T data) {
        if (data == null) throw new IllegalArgumentException("Null passed to enqueue");
        if (size == array.length) throw new IllegalArgumentException("Queue full");
        rear = incrementCounter(rear);
        array[rear] = data;
        size++;
    }
    public T dequeue() {
        if (size == 0) return null;
        T data = array[front];
        front = incrementCounter(front);
        size--;
        return data;
    }
    public T peek() {
        if (size == 0) return null;
        return array[front];
    }
    public int size() { return size; }
    public int capacity() { return array.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == array.length; }

    private int incrementCounter(int i) {
        if (i == array.length - 1) return 0;
        return i + 1;
    }

}
