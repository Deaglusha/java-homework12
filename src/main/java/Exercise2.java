import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
        Задание 2
        Напишите программу, которая выводит в консоль строку, состоящую из чисел от 1 до n, но с заменой некоторых
        значений:
        если число делится на 3 - вывести "fizz"
        если число делится на 5 - вывести "buzz"
        если число делится на 3 и на 5 - вывести "fizzbuzz"
        Например, для n = 15, ожидаемый результат:
        1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

        Программа должна быть многопоточной, работать с 4 потоками:
        Поток A вызывает fizz() чтобы проверить делимость на 3 и вывести fizz.
        Поток B вызывает buzz() чтобы проверить делимость на 5 и вывести buzz.
        Поток C вызывает fizzbuzz() чтобы проверить делимость на 3 и 5 и вывести fizzbuzz.
        Поток D вызывает number() чтобы вывести число.
*/

public class Exercise2 implements Runnable {
    private final Lock lock;
    private final Condition oneSecondCondition;

    public Exercise2(Lock lock, Condition oneSecondCondition) {
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
