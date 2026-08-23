import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerThreadFactory implements ThreadFactory {
    private final String poolName;
    private final AtomicInteger threadNumber = new AtomicInteger(1);


    public CustomerThreadFactory() {
        this.poolName = "MyPool";
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(poolName + "-thread-" + threadNumber.getAndIncrement());
        return thread;
    }
}
