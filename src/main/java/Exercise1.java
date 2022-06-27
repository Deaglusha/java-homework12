import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import static java.lang.Thread.sleep;

/*
        Задание 1
        Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии
        (запуска программы).

        Другой ее поток выводит каждые 5 секунд сообщение "Прошло 5 секунд". Предусмотрите возможность ежесекундного
        оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.
*/

public class Exercise1 implements Runnable {
    private final Long startTime;
    private final Lock lock;
    private final Condition oneSecondCondition;

    public Exercise1(Long startTime, Lock lock, Condition oneSecondCondition) {
        this.startTime = startTime;
        this.lock = lock;
        this.oneSecondCondition = oneSecondCondition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
                lock.lock();
                System.out.printf("Поток - %s. Секунд, от начала сессии - %d.%n",
                        Thread.currentThread().getName(), (System.currentTimeMillis() - startTime) / 1000);
                oneSecondCondition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
