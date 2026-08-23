import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //UseCase 1
        Future<?> futureObj1 = poolExecutor.submit(() -> {
            System.out.println("Task 1 with Runnable");
        });

        try {
            Object object = futureObj1.get();
            System.out.println(object == null);
        }
        catch (Exception e) {
        }

        //UseCase 2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj2 = poolExecutor.submit(new MyRunnable(output, "Task 2 with Runnable and Return object"), output);

        try {
            List<Integer> result2 = futureObj2.get();
            System.out.println(result2.get(0));
        }
        catch (Exception e) {
        }

        //UseCase 3
        Future<List<Integer>> future0bj3 = poolExecutor.submit(() -> {
            System.out.println("Task 3 with Callable");
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            return listObj;
        });

        try {
            List<Integer> result3 = future0bj3.get();
            System.out.println(result3.get(0));
        }
        catch (Exception e) {
        }

        poolExecutor.shutdown();
    }
}
