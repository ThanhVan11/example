import java.util.concurrent.*;

public class FutureComparison {
    public static void main(String[] args) {
        System.out.println("=== CÁCH 1: ĐƠN LUỒNG ===");
        long start1 = System.currentTimeMillis();
        String result1 = task1();
        System.out.println("Main thread đang làm việc khác...");
        doOtherWork();
        String result2 = task2();
        System.out.println(result1 + "\n" + result2);
        System.out.println("Thời gian Đơn luồng: " + (System.currentTimeMillis() - start1) + " ms\n");


        System.out.println("=== CÁCH 2: ĐA LUỒNG VỚI THREAD POOL & FUTURE ===");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 2, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        long start2 = System.currentTimeMillis();

        Future<String> future1 = executor.submit(() -> task1());
        Future<String> future2 = executor.submit(() -> task2());
        System.out.println("Main thread tranh thủ làm việc khác trong khi 2 task kia chạy ngầm...");
        doOtherWork();

        try {
            String futureResult1 = future1.get();
            String futureResult2 = future2.get();

            System.out.println(futureResult1 + "\n" + futureResult2);
            System.out.println("Thời gian Đa luồng: " + (System.currentTimeMillis() - start2) + " ms");
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            executor.shutdown();
        }
    }

    private static void doOtherWork() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-> Việc khác đã xong!");
    }


    private static String task1() {
        try {
            Thread.sleep(2000);
            System.out.println("Task 1 đang làm việc");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "task 1 hoàn thành!";
    }

    private static String task2() {
        try {
            Thread.sleep(3000);
            System.out.println("Task 2 đang làm việc");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "task 2 hoàn thành!";
    }

}
