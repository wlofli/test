
public class TanktimeProxy implements Moveable{  
        private Moveable t;  
      
        public TanktimeProxy(Moveable t) {  
            super();  
            this.t = t;  
        }  

		@Override
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
