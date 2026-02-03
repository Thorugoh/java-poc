import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        ExecutorService es = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>()
        );

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep((300));
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        es.execute(runnableTask);
        Future<String> future = es.submit(callableTask);

        String result = es.invokeAny(callableTasks);
    }
}