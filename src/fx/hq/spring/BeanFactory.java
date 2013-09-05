package fx.hq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {
	private static final String SPRING_CONFIG_NAME = "applicationContext-common.xml";
	private static ApplicationContext context;
	
	private BeanFactory() {
	}
	
	public static ApplicationContext getApplicationContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(SPRING_CONFIG_NAME);
		}
		return context;
	}
}
