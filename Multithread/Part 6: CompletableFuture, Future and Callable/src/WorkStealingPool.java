import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newWorkStealingPool(2);

        ForkJoinPool pool2 = ForkJoinPool.commonPool();
        Future<Integer> future = pool2.submit(new ComputeSumTask(0, 100));

        try{
            System.out.println(future.get());
        }catch (Exception e){
        }

        pool1.shutdown();

    }
}