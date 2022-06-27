import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Exercise1
        /*Long timeStart = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        Condition oneSecondCondition = lock.newCondition();

        new Thread(new Exercise1_1(timeStart, lock, oneSecondCondition)).start();
        new Thread(new Exercise1_2(lock, oneSecondCondition)).start();*/

        //Exercise2
        Thread threadA = new Thread(new Exercise2_A());
        Thread threadB = new Thread(new Exercise2_B());
        Thread threadC = new Thread(new Exercise2_C());
        Thread threadD = new Thread(new Exercise2_D());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        IntStream.range(1, 16).forEach(Exercise2::processNumber);

        threadA.interrupt();
        threadB.interrupt();
        threadC.interrupt();
        threadD.interrupt();

        System.out.println(Exercise2.result.deleteCharAt(0).toString().replace(" ", ", "));
    }
}
