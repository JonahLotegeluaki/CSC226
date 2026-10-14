package medical_action_tracking;

public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public LinkedStack() {
        size = 0;
        top = null;
    }

    public void push(T item) {
        if (item == null) throw new IllegalArgumentException();
        Node n = new Node(item);
        n.next = top;
        top = n;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node n = top;
        StringBuilder sb = new StringBuilder("[");
        while (n != null) {
            sb.append(String.format(n.next == null ? "%s]" : "%s, ", n.data.toString()));
            n = n.next;
        }
        return sb.toString();
    }
}
