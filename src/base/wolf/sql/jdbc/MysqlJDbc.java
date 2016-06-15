package base.wolf.sql.jdbc;

import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
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
			Properties props =Resources.getResourceAsProperties("conf/jdbc.properties");

			String url = props.getProperty("jdbc.url").split("mdb")[0];
//			String url = url + dbname;
			
		    String driver = props.getProperty("jdbc.driverClassName");
		    String username = props.getProperty("jdbc.username");
		    String password = props.getProperty("jdbc.password");
		    Class.forName(driver).newInstance();
//		    Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		    
			ScriptRunner runner = new ScriptRunner(conn, false, false);
//			SqlSessionFactoryBuilder sfBuilder  undone
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		return null;
	}
	
	
	
	

}
