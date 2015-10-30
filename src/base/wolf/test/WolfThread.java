package base.wolf.test;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class WolfThread  extends Thread{
	private  int points = 500;

	public  int getPoints() {
		return points;
	}

	public  void setPoints(int points) {
		this.points = points;
	}
	
	protected void minusPoints(){
		for (int i = 0; i < 500; i++) {
			points --;
			System.out.println("the last points "+ this.getName() + " " + points);
		}
	}
	
	

}
