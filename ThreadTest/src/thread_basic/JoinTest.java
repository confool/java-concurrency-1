package thread_basic;

public class JoinTest extends Thread {

	public JoinTest(String name) {
		super(name);
	}
	
	@Override
	public void run()
	{
		try {
			//睡眠4000ms
			Thread.sleep(4000);
			System.out.println("sleep finish");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Thread t = new JoinTest("Join Test");
		t.start();

		try {
			long startTime = System.nanoTime();
			//等待t完成，超时1000ms
			t.join(1000);
			long endTime = System.nanoTime();
			//1000ms后t被中断
			t.interrupt();
			System.out.println("cost Time:"+(endTime-startTime)/1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
