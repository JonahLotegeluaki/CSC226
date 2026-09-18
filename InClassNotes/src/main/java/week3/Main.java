package week3;

public class Main {
    public static void main(String[] args) {
        ArrayBoundedStack<String> stack = new ArrayBoundedStack<>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cantaloupe");
        System.out.printf("Cantaloupe = %s\n", stack.peek());
        System.out.printf("Cantaloupe = %s\n", stack.pop());
        System.out.printf("Banana = %s\n", stack.pop());
        System.out.printf("Apple = %s\n", stack.pop());
    }
}
