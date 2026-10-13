package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        size = 0;
        front = null;
        rear = null;
    }

    public void enqueue(T item) {
        if (item == null) throw new IllegalArgumentException();
        Node n = new Node(item);
        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }

    public T peekFront() {
        if (isEmpty()) return null;
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // OPTIONAL ===============
    public boolean checkSize() {
        int reccount = rec(0, front);
        if (reccount != size) return false;
        return true;
    }
    private int rec(int i, Node n) {
        if (n == null) return i;
        return rec(i+1, n.next);
    }
    // ==========================

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        // TODO: Recursively build a string from front to rear without changing the queue.
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        appendNodesRecursively(front, sb);
        sb.append(']');
        return sb.toString();
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // TODO: Add the current node's data, then recursively visit current.next.
        // TODO: Stop at the null-node base case.
        if (current == null) return;
        result.append(String.format(
            current.next == null ? "%s" : "%s, ",
            current.data.toString()));
        appendNodesRecursively(current.next, result);

    }
}
