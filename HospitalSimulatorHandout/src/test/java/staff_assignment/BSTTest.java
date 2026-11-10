package staff_assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

// Tests for the BST node stuff
public class BSTTest {
    @Test
    public void testIsLeafNode() {
        BSTNode<Integer> n = new BSTNode<>(10);
        assertTrue(n.isLeafNode());
        
        n.setLeft(new BSTNode<>(5));
        assertFalse(n.isLeafNode());
        n.setLeft(null);
        n.setRight(new BSTNode<>(15));
        assertFalse(n.isLeafNode());
    }

    // Test recursive size
    @Test
    public void testSizeRec() {
        // single
        BSTNode<Integer> n = new BSTNode<>(10);
        assertEquals(1, n.size_rec());
        // multiple
        n.setLeft(new BSTNode<>(5));
        n.setRight(new BSTNode<>(15));
        assertEquals(3, n.size_rec());
    }

    // Test iterative size
    @Test
    public void testSizeIt() {
        // single
        BSTNode<Integer> n = new BSTNode<>(10);
        assertEquals(1, n.size_it());
        // multiple
        n.setLeft(new BSTNode<>(5));
        n.setRight(new BSTNode<>(15));
        assertEquals(3, n.size_it());
    }

    // idk why i keep writing these comments when the purpose is in the function name
    @Test
    public void testInsert() {
        BSTNode<Integer> n = new BSTNode<>(10);
        n.insert(5);
        n.insert(15);
        assertEquals(3, n.size_rec());
        assertEquals(5, n.getLeft().getData());
        assertEquals(15, n.getRight().getData());
    }

    // Test the traversal algorithms, all at once
    @Test
    public void testTraversal() {
        BSTNode<Integer> n = new BSTNode<>(50);
        n.insert(25);
        n.insert(75);
        n.insert(10);
        n.insert(30);
        n.insert(60);
        n.insert(90);
        assertEquals(
            Arrays.asList(50, 25, 10, 30, 75, 60, 90),
            n.preOrder()
        );
        assertEquals(
            Arrays.asList(10, 25, 30, 50, 60, 75, 90),
            n.inOrder()
        );
        assertEquals(
            Arrays.asList(10, 30, 25, 60, 90, 75, 50),
            n.postOrder()
        );
    }
}