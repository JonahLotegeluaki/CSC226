package week4;

public class LLNode<T> {
    T info;
    LLNode<T> next;

    public LLNode(T info){
        this.info = info;
        next = null;
    }
    public void setNext(LLNode<T> next){
        this.next = next;
    }
    public LLNode<T> getNext(){
        return next;
    }
    public void setInfo(T info){
        this.info = info;
    }
    public T getInfo(){
        return info;
    }
}