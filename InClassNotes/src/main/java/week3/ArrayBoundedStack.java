package week3;

public class ArrayBoundedStack<T> implements StackInterface<T> {
    private final int DEFAULTCAP = 100;
    private T[] stack;
    private int sp = -1;

    public ArrayBoundedStack(){
        stack = (T[]) new Object[DEFAULTCAP];
    }
    public ArrayBoundedStack(int maxSize){
        stack = (T[]) new Object[maxSize];
    }
    public boolean isEmpty()
    {
        if (sp == -1) return true;
        return false;
    }

    public boolean isFull()
    {
        if (sp == stack.length - 1) return true;
        return false;
    }
    
    public void push(T element)
    {
        if (isFull()) return;
        sp++;
        stack[sp] = element;
    }
    
    public T pop()
    {
        if (isEmpty()) return null;
        sp--;
        return stack[sp+1];

    }
    
    public T peek()
    {
      return stack[sp];   
    }
}