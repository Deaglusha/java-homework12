import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Long timeStart = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        Condition oneSecondCondition = lock.newCondition();

        new Thread(new Exercise1_1(timeStart, lock, oneSecondCondition)).start();
        new Thread(new Exercise1_2(lock, oneSecondCondition)).start();


        
    }
}
