import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return counter;
        }finally {
            lock.unlock();
        }
    }
}
