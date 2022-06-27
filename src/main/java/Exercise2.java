import java.util.concurrent.CyclicBarrier;

public class Exercise2 {
    public static final CyclicBarrier BARRIER_READY_TO_CHECK_NUMBER = new CyclicBarrier(5);
    public static final CyclicBarrier BARRIER_READY_TO_PRINT_NUMBER = new CyclicBarrier(5);
    public static final CyclicBarrier BARRIER_READY_TO_NEXT_NUMBER = new CyclicBarrier(5);

    public static volatile int currentNumber = 0;
    public static volatile byte currentNumberState = 0;
    public static volatile StringBuilder result = new StringBuilder("");

    public static void processNumber(int n) {
        currentNumber = n;
        currentNumberState = 0;
        try {
            BARRIER_READY_TO_CHECK_NUMBER.await();
            BARRIER_READY_TO_PRINT_NUMBER.await();
            BARRIER_READY_TO_NEXT_NUMBER.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
