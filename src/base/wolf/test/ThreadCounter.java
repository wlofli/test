package base.wolf.test;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class ThreadCounter implements Runnable {
	
	private int c;
	
	public void add() throws Exception{
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				c++;
				System.out.println(c);
			}
		}
	}
	
	public void addWhihOutSynchronized() throws Exception{
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			c++;
			System.out.println(c);
		}
		
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			staticClassAdd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void staticadd() throws Exception{
		synchronized(ThreadCounter.class){
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		
		}
			
	}
	
	
	
	public static void staticClassAdd() throws Exception{
		synchronized(ThreadCounter.class){
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println(i+ "haha");
			}
		
		}
		
	}
	
	

}
