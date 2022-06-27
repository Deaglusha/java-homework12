public class Exercise2_C implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Exercise2.BARRIER_READY_TO_CHECK_NUMBER.await();
                fizzbuzz(Exercise2.currentNumber);
                Exercise2.BARRIER_READY_TO_PRINT_NUMBER.await();

                if (Exercise2.currentNumberState == 3) {
                    Exercise2.result.append(" ").append("fizzbuzz");
                }

                Exercise2.BARRIER_READY_TO_NEXT_NUMBER.await();
            }
        } catch (Exception e) {

        }
    }

    private void fizzbuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            Exercise2.currentNumberState |= (1 << 0);
            Exercise2.currentNumberState |= (1 << 1);
        }
    }
}
