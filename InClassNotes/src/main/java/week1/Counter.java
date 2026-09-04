package week1;

public class Counter {

    // 2. Add a private field
    // TODO: Declare private int count;

    // 3. Write the default constructor

    // 4. Add an alternate constructor

    // 5. Write an accessor method

    // 6. Add an update method
    
    // 7. Overload increment
   
    // 8. Add a reset method

    //9. Add a fixed-size history array that records the last 5 states of the counter. All logic must happen inside of the object and be hidden from the user.
    
    
    private int count;
    private int[] hist = new int[5];

    private void appendHist(int n) {
        // Shift all elements right, discarding [4]
        for (int i=4;i>0;i--) {
            hist[i] = hist[i-1];
        }

        hist[0] = n;
    }


    public Counter() {
        count = 0;
    }
    public Counter(int i) {
        count = i;
    }

    public int getCount() { return count; }
    public void increment() {
        count += 1;
        appendHist(count);
    }
    public void increment(int c) {
        count += c;
        appendHist(count);
    }

    public void reset() {
        count = 0;
        appendHist(count);
    }


}