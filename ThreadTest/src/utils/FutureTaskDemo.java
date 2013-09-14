package utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//FutureTask可以用于一些复杂耗时的计算，get会阻塞，直至完成callable中的计算，返回结果。
//如此例中main中调用FutureTask，会等待5s，才能输出结果1

public class FutureTaskDemo {

	private final FutureTask<Integer> ft = new FutureTask<Integer>(
			new Callable<Integer>() {
				public Integer call()
				{
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 1;
				}
			}
		);
	
	private final Thread t = new Thread(ft);
	
	public void start()
	{
		t.start();
	}
	
	public Integer getResult()
	{
		try {
			return ft.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		FutureTaskDemo demo = new FutureTaskDemo();
		
		System.out.println("ask for result");
		demo.start();
		System.out.println(demo.getResult());
	}
}
