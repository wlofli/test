
public class testTank {

	
	
	public static void main(String[] args) {  
        Tank t = new Tank();  
        Moveable move = new TanktimeProxy(t);  
        move.move();  
      
    }  
}
