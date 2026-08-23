import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCompare {
    public static void main(String[] args) {
        System.out.println("use thenApply");
        CompletableFuture<CompletableFuture<Integer>> future1 = add(10, 5)
                .thenApply(tong -> subtract(tong, 3));

        try {
            Integer resultApply = future1.get().get();
            System.out.println("Kết quả thenApply: " + resultApply + "\n");
        }
        catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        System.out.println("use thenCompose");
        CompletableFuture<Integer> flatFuture = add(10, 5)
                .thenCompose(tong -> subtract(tong, 3));
        try {
            Integer resultCompose = flatFuture.get();
            System.out.println("Kết quả thenCompose: " + resultCompose);
        }
        catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<Integer> add(int a, int b) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("[Thread: " + Thread.currentThread().getName() + "] Đang tính: " + a + " + " + b);
            return a + b;
        });
    }

    public static CompletableFuture<Integer> subtract(int a, int b) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("[Thread: " + Thread.currentThread().getName() + "] Đang tính: " + a + " - " + b);
            return a - b;
        });
    }
}
