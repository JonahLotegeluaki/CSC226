package week5;

public class Main {
    public static void main(String[] args) {
        ArrayUnboundedQueue<String> auq = new ArrayUnboundedQueue<String>();
        auq.enqueue("First");
        auq.enqueue("Second");
        auq.enqueue("Third");
        System.out.println(auq.dequeue());
        auq.enqueue("Fourth");  // Array is at the end, but not full; index 0 is free
        auq.enqueue("Fifth");   // Array is now full
        System.out.printf("%b == false\n", auq.isFull());
        auq.enqueue("Sixth");   // Expansion nonsense triggers
        for (int i=0;i<5;i++)
            System.out.println(auq.dequeue());
        System.out.printf("%b == true\n", auq.isEmpty());
    }   
}
