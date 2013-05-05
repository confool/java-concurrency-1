package thread_basic;
/**
 * 与同步锁(时间换空间)不同，ThreadLocal(空间换时间)为每个Thread创建某变量的局部拷贝，
 * 通过访问各自拷贝的方式解决同步问题。
 * 线程池中，对每个标识不同的线程，都产生一份拷贝
 * @author Administrator
 *
 */
public class ThreadLocalTest {

	public static ThreadLocal<Integer> num = new ThreadLocal<Integer>()
	{
		//覆盖initialValue,否则默认返回null
		public Integer initialValue()
		{
			return 0;
		}
	};
	
	public static int getNextNum()
	{
		num.set(num.get()+1);
		return num.get();
	}

	public static class TestThread extends Thread
	{
		private int _id;
		
		public TestThread(int id)
		{
			_id = id;
		}
		
		@Override
		public void run()
		{
			for(int i=0; i<3; i++)
			{
				System.out.println("Thread id: "+this._id+", num:"+getNextNum());
			}
		}
	}

	public static void main(String args[])
	{
		TestThread tt1 = new TestThread(1);
		TestThread tt2 = new TestThread(2);
		TestThread tt3 = new TestThread(3);
		
		tt1.start();
		tt2.start();
		tt3.start();
	}
}
