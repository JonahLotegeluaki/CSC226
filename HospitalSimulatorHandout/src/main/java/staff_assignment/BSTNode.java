package staff_assignment;

import java.util.ArrayList;
import java.util.List;

import medical_action_tracking.LinkedStack;


// The md file was a little unclear, and the assignment file was not linked on canvas
// So im assuming im supposed to implement a generic binary search tree?
public class BSTNode<T extends Comparable<T>> {
    private BSTNode<T> left;
    private BSTNode<T> right;
    private T data;

    public BSTNode(T data) {
        left = null;
        right = null;
        this.data = data;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    // Recursive size
    public int size_rec() {
        int size = 1;
        if (left != null) size += left.size_rec();
        if (right != null) size += right.size_rec();
        return size;
    }

    // Iterative size
    public int size_it() {
        int size = 0;
        LinkedStack<BSTNode<T>> st = new LinkedStack<>();
        st.push(this);

        while (!st.isEmpty()) {
            BSTNode<T> n = st.pop();
            size++;
            if (n.getRight() != null) {
                st.push(n.getRight());
            }
            if (n.getLeft() != null) {
                st.push(n.getLeft());
            }
        }
        return size;
    }

    // Self explanatory methods
    public boolean isLeafNode() {
        return left == null && right == null;
    }
    public BSTNode<T> getLeft() {
        return left;
    }
    public BSTNode<T> getRight() {
        return right;
    }
    public void setLeft(BSTNode<T> n) {
        left = n;
    }
    public void setRight(BSTNode<T> n) {
        right = n;
    }
    // Most enigmatic method here
    public T getData() {
        return data;
    }

    // FIVE levels of nesting :O
    // Search through until a valid opening is found
    public void insert(T item) {
        BSTNode<T> n = this;
        while (true) {
            if (item.compareTo(n.getData()) > 0) {
                // Right
                if (n.getRight() == null) {
                    n.setRight(new BSTNode<T>(item));
                    return;
                }
                n = n.getRight();
            } else {
                // Left and duplicates
                if (n.getLeft() == null) {
                    n.setLeft(new BSTNode<T>(item));
                    return;
                }
                n = n.getLeft();
            }
        }
    }

    // Recursively look for the longest path from root to a leaf node
    public int height() {
        if (isLeafNode())   // Easy answer!
            return 0;
        // -1 is the "height" of an empty tree (for comparison)
        int leftHeight = -1;
        int rightHeight = -1;
        if (left != null) {
            leftHeight = left.height();
        }
        if (right != null) {
            rightHeight = right.height();
        }
        // Get the longest 
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Traversals
    public List<T> preOrder() {
        ArrayList<T> res = new ArrayList<>();
        res.add(data);
        if (left != null) res.addAll(left.preOrder());
        if (right != null) res.addAll(right.preOrder());
        return res;
    }
    public List<T> inOrder() {
        ArrayList<T> res = new ArrayList<>();
        if (left != null) res.addAll(left.inOrder());
        res.add(data);
        if (right != null) res.addAll(right.inOrder());
        return res;
    }
    public List<T> postOrder() {
        ArrayList<T> res = new ArrayList<>();
        if (left != null) res.addAll(left.postOrder());
        if (right != null) res.addAll(right.postOrder());
        res.add(data);
        return res;
    }
}
