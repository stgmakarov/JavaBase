import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Stanislav Makarov
 */
public class FlowPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(24);
        for(int i = 0;i<100000000;i++)
            executorService.submit(new WorkerPool(100000));
        executorService.shutdownNow();

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class WorkerPool implements Runnable{
    int num;
    public WorkerPool(int num){
        this.num = num;
    }

    @Override
    public void run() {
        long cnt=1;
        for(int i = 0; i<num;i++)
            for(int j = 0;j<num;j++){
                cnt = cnt +i+j;
            }
        System.out.println(cnt);
    }
}
