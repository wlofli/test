import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class DynamicProxy implements InvocationHandler{
	
	private Object oj;
	
	
	public DynamicProxy(){}
	
	public DynamicProxy(Object object){
		this.oj = object;
	}

	public Object invoke(Object object, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(method);
		System.out.println("before");
		method.invoke(oj, args);
		System.out.println("end");
//		System.out.println(object.toString());
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		Robot robin = new Robot();
		InvocationHandler handler = new DynamicProxy(robin);
		Runnable robot = (Runnable) Proxy.newProxyInstance(handler.getClass().getClassLoader(), robin.getClass().getInterfaces(), handler);
		robot.run();
	}

}



interface Runnable{
	 void run();
}

class Robot implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("robin run!!!");
	}
	
}


