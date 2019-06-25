package thread_basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolTest {

    static class Runner implements Runnable {
        int index = 0;

        public Runner(int idx) {
            this.index = idx;
        }

        @Override
        public void run() {
            long sleepTime = (long) (Math.random() * 1000);
            System.out.println("Thread:" + Thread.currentThread().getName() + "; runner index:" + index + "; sleep:" + sleepTime + "ms");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exs = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Runnable r = new Runner(i);
            exs.execute(r);
        }
        exs.shutdown();
    }
}
