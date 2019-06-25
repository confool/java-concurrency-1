package utils;

import java.util.concurrent.LinkedBlockingQueue;

//BlockQueue常用于生产者-消费者模型
//四核cpu，占用25%, 为main中while循环占用，LinkedBlockingQueue的take是await等待唤醒式的。

public class BlockingQueueDemo {

    public static class MyThread extends Thread {
        private LinkedBlockingQueue<Integer> _q;

        public MyThread(LinkedBlockingQueue<Integer> q) {
            _q = q;
        }

        public void run() {
            while (true) {
                try {
                    _q.take();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
        MyThread t = new MyThread(q);
        t.start();

        while (true) {

        }
    }
}
