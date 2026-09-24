package week4;
import week3.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;

    public LinkedStack(){
        this.top = null;
    }

    public void push(T element){
        LLNode<T> node = new LLNode<T>(element);
        if (top == null) {
            top = node;
            return;
        }
        node.setNext(top);
        top = node;

    }
    public T pop(){
        T a = top.getInfo();
        top = top.getNext();
        return a;
    }
    public T peek(){
        return top.getInfo();
    }

    public boolean isEmpty(){
        if (top == null) return true;
        return false;
    }
    public boolean isFull(){
        return false;
    }
}