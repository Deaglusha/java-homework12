public class Exercise2_A implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Exercise2.BARRIER_READY_TO_CHECK_NUMBER.await();
                fizz(Exercise2.currentNumber);
                Exercise2.BARRIER_READY_TO_PRINT_NUMBER.await();

                if (Exercise2.currentNumberState == 1) {
                    Exercise2.result.append(" ").append("fizz");
                }

                Exercise2.BARRIER_READY_TO_NEXT_NUMBER.await();
            }
        } catch (Exception e) {

        }
    }

    private void fizz(int number) {
        if (number % 3 == 0) Exercise2.currentNumberState |= (1 << 0);
    }
}
