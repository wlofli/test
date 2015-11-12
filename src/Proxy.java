
public class Proxy {
	public static void main(String[] args) {  
        Tank t = new Tank();  
        Moveable move = new TanktimeProxy(t);  
        move.move();  
      
    }  
}

class Tank implements Moveable{

	public void move() {
		// TODO Auto-generated method stub
	            System.out.println("TanK moving........");  
	}  
  
       
      
}  
 
interface Moveable {void move();}
class TanktimeProxy implements Moveable{  
     private Moveable t;  
     public TanktimeProxy(Moveable t) {  
         super();  
         this.t = t;  
     }

		public void move() {
			// TODO Auto-generated method stub
			long time1 = System.currentTimeMillis();  
         System.out.println("time1="+time1);  
         t.move();  
         long time2 = System.currentTimeMillis();  
         System.out.println("time2="+time2);  
         System.out.println("运行时间为:"+(time2-time1));  
		}  

}