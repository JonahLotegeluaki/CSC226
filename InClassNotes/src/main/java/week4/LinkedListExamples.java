package week4;

import java.util.ArrayList;

public class LinkedListExamples {
    public static void main(String[] args){
        // Create a sample linked list for testing
        LLNode<String> head = new LLNode<>("First");
        head.setNext(new LLNode<>("Second"));
        head.getNext().setNext(new LLNode<>("Third"));
        head.getNext().getNext().setNext(new LLNode<>("Fourth"));
        
        // Test your functions here
        displayWithPositions(head);

        // Double the list
        LLNode<String> head2 = copyList(head);
        getElementAt(head, getLength(head) - 1).setNext(head2);
        System.out.printf("Length: %d\n", getLength(head));
        displayWithPositions(head);
        System.out.printf("Expect true: %b, expect false: %b\n", contains(head, "Third"), contains(head, "Fifth"));
        removeElement(head, "Third");
        displayWithPositions(head);
        ArrayList<String> al = toArrayList(head);
        for (String s : al) {
            System.out.printf("String    %-10s length %d\n", s, s.length());
        } 
    }
    
    
    /**
     * 2. Program to display both elements and their position in a linked list
     * Shows: Position 0: "First", Position 1: "Second", etc.
     */
    public static <T> void displayWithPositions(LLNode<T> head) {
        int i = 0;
        LLNode<T> node = head;
        while (true) {
            System.out.printf("%3d %s\n", i, node.getInfo().toString());
            node = node.getNext();
            i++;
            if (node == null) break;
        }
    }
    
    /**
     * 3. Program to remove a specified element from a linked list
     * Returns the new head of the list (important if first element is removed)
     */
    public static <T> LLNode<T> removeElement(LLNode<T> head, T target) {
        if (head.getInfo() == target) {
            if (head.getNext() == null) return null;
            return head.getNext();
        }
        // 1 Find the element
        LLNode<T> prev = null, curr = head;
        // atrocious nesting sorry
        while (curr.getInfo() != target) {
            prev = curr;
            curr = curr.getNext();
            if (curr == null) return null;    // End of list, didnt find it
        }
        // 2 Excise the node
        if (curr.getNext() == null) {
            prev.setNext(null);
            return head;
        }
        prev.setNext(curr.getNext());
        return head;
    }
    
    /**
     * 4. Program to remove all elements from a linked list
     * Returns null (empty list)
     */
    public static <T> LLNode<T> removeAllElements(LLNode<T> head) {
        return null;
    }
    
    /**
     * 5. Program to copy a linked list to another linked list
     * Creates a completely new list with the same values
     */
    public static <T> LLNode<T> copyList(LLNode<T> original) {
        if (original == null) return null;
        LLNode<T> base = new LLNode<T>(original.getInfo()), oldNode, newNode;
        if (original.getNext() == null) return base;
        oldNode = original.getNext();
        newNode = new LLNode<T>(oldNode.getInfo());
        base.setNext(newNode);
        while (oldNode != null) {
            newNode.setNext(oldNode.getNext() == null ? null : new LLNode<T>(oldNode.getNext().getInfo()));
            newNode = newNode.getNext();
            oldNode = oldNode.getNext();
        }
        return base;
    }
    
    /**
     * 6. Program to check if a particular element exists in a linked list
     * Returns true if found, false otherwise
     */
    public static <T> boolean contains(LLNode<T> head, T target) {
        LLNode<T> node = head;
        while (node != null) {
            if (node.getInfo() == target) return true;
            node = node.getNext();
        }
        return false;
    }
    
    /**
     * Helper function to calculate the length of a linked list
     * Useful for other operations
     */
    public static <T> int getLength(LLNode<T> head) {
        int i = 0;
        LLNode<T> node = head;
        while (node != null) {
            node = node.getNext();
            i++;
        }
        return i;
    }

    /**
     * 7. Program to convert a linked list to an array list
     * Returns an ArrayList containing all elements in the same order
     */
    public static <T> ArrayList<T> toArrayList(LLNode<T> head) {
        ArrayList<T> al = new ArrayList<>();
        LLNode<T> node = head;
        while (node != null) {
            al.add(node.getInfo());
            node = node.getNext();
        }
        return al;
    }
        
    /**
     * Helper function to get the element at a specific position
     * Returns null if position is out of bounds
     */
    public static <T> LLNode<T> getElementAt(LLNode<T> head, int position) {
        int i = 0;
        LLNode<T> node = head;
        while (node != null) {
            if (i == position) return node;
            node = node.getNext();
            i++;
        }
        return null;
    }
}
