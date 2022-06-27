public class Exercise2_D implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Exercise2.BARRIER_READY_TO_CHECK_NUMBER.await();
                Exercise2.BARRIER_READY_TO_PRINT_NUMBER.await();

                if (Exercise2.currentNumberState == 0) {
                    number(Exercise2.currentNumber);
                }

                Exercise2.BARRIER_READY_TO_NEXT_NUMBER.await();
            }
        } catch (Exception e) {

        }
    }

    public static void number(int number) {
        Exercise2.result.append(" ").append(number);
    }
}
