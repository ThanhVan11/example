import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newCachedThreadPool(new CustomerThreadFactory());
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Task " + taskId + " -> " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        pool.shutdown();
    }
}
