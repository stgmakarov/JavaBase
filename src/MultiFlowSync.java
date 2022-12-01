/**
 * @author Stanislav Makarov
 */
public class MultiFlowSync {
    private int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        MultiFlowSync test = new MultiFlowSync();
        test.doWork();
    }

/*    public synchronized void increment(){
        counter++;
    }*/

    public void increment(){
        synchronized (this) {
            counter++;
        }
    }

    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int idx = 0;
                while (idx < 10000) {
                    increment();
                    idx++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int idx = 0;
                while (idx < 10000) {
                    increment();
                    idx++;
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}


