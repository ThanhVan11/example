import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutor {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(2);
        ExecutorService pool = Executors.newFixedThreadPool(2, new CustomerThreadFactory());
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
