import javax.swing.plaf.basic.BasicBorders;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Stanislav Makarov
 */
public class SyncWithLock {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }

}

class Worker{
    Object lock1 = new Object();
    Object lock2 = new Object();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    Random rnd = new Random();

    void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(rnd.nextInt(100));
        }
    }

    void addToList2(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(rnd.nextInt(100));
        }
    }

    void worker(){
        for (int i =0; i<1000;i++) {
            addToList1();
            addToList2();
        }
    }

    void main() throws InterruptedException {
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


        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime-startTime));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());

    }


}

