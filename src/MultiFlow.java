import java.util.Scanner;

public class MultiFlow {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyThread myThread1 = new MyThread("Hello from thread1");
        MyThread myThread2 = new MyThread("Hello from thread2");
        myThread1.start();
        myThread2.start();
        //Thread runner = new Thread(new Runner("Hello from Runner"));
        //runner.start();

        System.out.println("Hello from MAIN");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        myThread1.shutdown();
        myThread2.shutdown();
    }
}

class Runner implements Runnable{
    String msg;
    Runner(String msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try {
                //Спать
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg + "   " + i);
        };
    }
}

class MyThread extends Thread{
    String msg;
    //volatile - переменная хранится в общем на все ядра кэше
    private volatile boolean running = true;
    MyThread(String msg){
        this.msg = msg;
    }
    public void run(){
        int i = 0;
        do{
            try {
                //Спать
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg + "   " + i++);
        }
        while (running);
    }

    public void shutdown(){
        running = false;
    }
}
