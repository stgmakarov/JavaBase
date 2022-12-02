import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Stanislav Makarov
 */
public class AllThreads {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Work1(1);
        Thread thread2 = new Work1(2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 0");
            }
        });

        thread3.start();
        thread3.join();

        Thread thread4 = new Thread(new Work2(1));
        Thread thread5 = new Thread(new Work2(2));

        thread4.start();
        thread5.start();

        thread4.join();
        thread5.join();

        ArrFiller arrFiller = new ArrFiller();

        PoolTest poolTest = new PoolTest();

    }

}

class Work1 extends Thread{
    int id;
    public Work1(int id) {
        this.id = id;
    }
    public void run(){
        System.out.println("Worker "+id);
    }
}

class Work2 implements Runnable{
    int id;
    public Work2(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Runnable: "+id);
    }
}

class ArrFiller{
    List<Double> list1 = new ArrayList<>();
    List<Double> list2 = new ArrayList<>();
    Object lockList1 = new Object();
    Object lockList2 = new Object();
    Random rnd = new Random();

    void fillList1(){
        synchronized (lockList1){
            list1.add(rnd.nextDouble());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void fillList2(){
        synchronized (lockList2) {
            list2.add(rnd.nextDouble());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void worker(){
        for(int i=0;i<1000;i++){
            fillList1();
            fillList2();
        }
    }


    public ArrFiller() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list1.size()+"  "+list2.size());
    }
}

class PoolTest{
    public PoolTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Pool task 1");
                for(int i = 0;i < 10000; i++){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Pool task 2");
                for(int i = 0;i < 10000; i++){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        executorService.shutdownNow();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
