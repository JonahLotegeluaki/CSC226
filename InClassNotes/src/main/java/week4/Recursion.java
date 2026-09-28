package week4;


public class Recursion {
    public int fib(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1) + fib(n-2));
    }
    public static Integer countHi(String value, int count) {
        if (value.length() < 2) return count;
        if (value.substring(0, 2).equalsIgnoreCase("hi")) countHi(value.substring(2), count += 1);
        countHi(value.substring(1), count);
        return -1; // unreachable
    }
    public static <T> void iterativePrinter(LLNode<T> node){
        while(node !=null){
            if(node.getInfo()!=null){
                System.out.println(node.getInfo());
            }
            node=node.getNext();
        }
    }
    public static <T> void recursivePrinter(LLNode<T> node){
       if (node == null) return;
       T info = node.getInfo();
       if (info == null) System.out.println(info);
       recursivePrinter(node.getNext());
    }

    public static <T> int recursiveCounter(LLNode<T> node, int counter){
        if (node == null) return counter;
        recursiveCounter(node.getNext(), counter += 1);
        return -1; // Should be unreachable
    }

}
