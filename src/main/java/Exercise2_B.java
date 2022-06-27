public class Exercise2_B implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Exercise2.BARRIER_READY_TO_CHECK_NUMBER.await();
                buzz(Exercise2.currentNumber);
                Exercise2.BARRIER_READY_TO_PRINT_NUMBER.await();

                if (Exercise2.currentNumberState == 2) {
                    Exercise2.result.append(" ").append("buzz");
                }

                Exercise2.BARRIER_READY_TO_NEXT_NUMBER.await();
            }
        } catch (Exception e) {

        }
    }

    private void buzz(int number) {
        if (number % 5 == 0) Exercise2.currentNumberState |= (1 << 1);
    }
}
