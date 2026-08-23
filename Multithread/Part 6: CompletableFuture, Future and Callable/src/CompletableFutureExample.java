import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1,
                    TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());


            CompletableFuture<String> asyncTask1 = CompletableFuture
                    .supplyAsync(() -> {
                        return "task 1 completed";
                    }, poolExecutor);
            System.out.println(asyncTask1.get());


            CompletableFuture<String> asyncTask2 = CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("[Task 2] Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "task 2 ";
                    }, poolExecutor)
                    .thenApply((String val) -> {
                        System.out.println("[Task 2] Thread name which runs 'thenApply': " + Thread.currentThread().getName());
                        return val + "completed";
                    });
            System.out.println("[Task 2] Thread name which runs 'after CF': " + Thread.currentThread().getName());
            System.out.println(asyncTask2.get());


            CompletableFuture<String> asyncTask3 = CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("[Task 3] Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "task 3 ";
                    }, poolExecutor)
                    .thenApplyAsync((String val) -> {
                        System.out.println("[Task 3] Thread name which runs 'thenApplyAsync': " + Thread.currentThread().getName());
                        return val + "completed";
                    });
            System.out.println(asyncTask3.get());


            CompletableFuture<String> asyncTask4 = CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("[Task 4] Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "task 4 ";
                    }, poolExecutor)
                    .thenCompose((String val) -> {
                        return CompletableFuture.supplyAsync(() -> {
                            System.out.println("[Task 4] Thread name which runs 'thenCompose': " + Thread.currentThread().getName());
                            return val + "completed";
                        });
                    })
                    .thenComposeAsync((String val) -> {
                        return CompletableFuture.supplyAsync(() -> {
                            System.out.println("[Task 4] Thread name which runs 'thenComposeAsync': " + Thread.currentThread().getName());
                            return val + ", end task";
                        });
                    });
            System.out.println(asyncTask4.get());


            CompletableFuture<Void> asyncTask5 = CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("[Task 5] Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "task 5 completed";
                    }, poolExecutor)
                    .thenAccept((String val) -> {
                        System.out.println("[Task 5] Thread name which runs 'thenAccept': " + Thread.currentThread().getName());
                        System.out.println("All stages completed: " + val);
                    });

            CompletableFuture<Void> asyncTask6 = CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("[Task 6] Thread name which runs 'supplyAsync': " + Thread.currentThread().getName());
                        return "task 6 completed";
                    }, poolExecutor)
                    .thenAcceptAsync((String val) -> {
                        System.out.println("[Task 6] Thread name which runs 'thenAcceptAsync': " + Thread.currentThread().getName());
                        System.out.println("All stages completed: " + val);
                    });

            CompletableFuture<Integer> asyncTask7 = CompletableFuture
                    .supplyAsync(() -> {
                        return 10;
                    }, poolExecutor);

            CompletableFuture<String> asyncTask8 = CompletableFuture
                    .supplyAsync(() -> {
                        return "k";
                    }, poolExecutor);
            CompletableFuture<String> combineFutureObj = asyncTask7.thenCombine(asyncTask8, (Integer val1, String val2) -> val1 + val2);
            System.out.println(combineFutureObj.get());


            poolExecutor.shutdown();
        }
        catch (Exception e) {
        }

    }
}
