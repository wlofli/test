package base.wolf.sql.jdbc;

import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class MysqlJDbc implements InvocationHandler{
	
	public static final String RESOURCE = "resource/conf/spring-mybatis.xml";
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Reader reader = null;
		SqlSessionFactory sf = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
//			SqlSessionFactoryBuilder sfBuilder  undone
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		return null;
	}
	
	
	
	

}
