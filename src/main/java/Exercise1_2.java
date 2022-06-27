import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
        Задание 1_2
        Другой ее поток выводит каждые 5 секунд сообщение "Прошло 5 секунд". Предусмотрите возможность ежесекундного
        оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.
*/

public class Exercise1_2 implements Runnable {
    private final Lock lock;
    private final Condition oneSecondCondition;

    public Exercise1_2(Lock lock, Condition oneSecondCondition) {
        this.lock = lock;
        this.oneSecondCondition = oneSecondCondition;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                try {
                    lock.lock();
                    oneSecondCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

            System.out.printf("Поток - %s. Прошло 5 секунд.%n", Thread.currentThread().getName());
        }
    }
}
