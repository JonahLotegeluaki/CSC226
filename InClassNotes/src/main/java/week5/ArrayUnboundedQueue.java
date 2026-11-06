package week5;

import java.util.ArrayList;

public class ArrayUnboundedQueue<T> implements QueueInterface<T> {
    private T[] array;
    private final int DEFAULT_SIZE = 4;
    private int front, rear;

    public ArrayUnboundedQueue() {
        array = (T[]) new Object[DEFAULT_SIZE];
        array[0] = null;
        front = 0;
        rear = 0;
    }

    private int advanceCounter(int i) {
        if (i == array.length - 1) return 0;
        return i + 1;
    }

    // most atrociously nested function ever
    @Override
    public void enqueue(T element) {
        if (front == array.length - 1) {    // Array is full, expand
            T[] newArray = (T[]) new Object[array.length * 2];
            if (rear < front) {     // Array is wrapped around itself, must reorder
                int i = 0;
                while (true) {
                    newArray[i] = array[front];
                    front = advanceCounter(front);
                    i++;
                    if (front == rear) break;
                }
            } else {
                // Just copy!
                for (int i=0;i<array.length;i++) {
                    newArray[i] = array[front + i];
                }
            }
            array = newArray;
        }   // End expansion
        // that is ugly and atrocious and i hate java

        rear = advanceCounter(rear);
        array[rear] = element;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T element = array[front];
        if (front == rear) {    // Array is now empty
            front = 0;
            rear = 0;
            array[0] = null;
        } else {
            front = advanceCounter(front);  // Array is not empty
        }
        return element;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (front == rear && array[front] == null) return true;
        return false;
    }
}