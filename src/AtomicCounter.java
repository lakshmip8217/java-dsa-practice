import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
