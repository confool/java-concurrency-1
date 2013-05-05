package utils;

import java.util.concurrent.LinkedBlockingQueue;

//四核cpu，占用25%

public class BlockingQueueDemo {
	public static class MyThread extends Thread
	{
		private LinkedBlockingQueue<Integer> _q;
		
		public MyThread(LinkedBlockingQueue<Integer> q)
		{
			_q = q;
		}
		
		public void run()
		{
			while(true)
			{
				try {
					_q.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
		MyThread t = new MyThread(q);
		t.start();
		
		while(true)
		{
			
		}
	}
}
