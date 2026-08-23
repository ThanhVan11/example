import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?> future = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("this is the task, which thread will execute");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("isDone: " + future.isDone());
        try {
            future.get(2, TimeUnit.SECONDS);
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException happened!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            future.get();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("isDone: " + future.isDone());
        System.out.println("isCancelled: " + future.isCancelled());

        poolExecutor.shutdown();
    }
}