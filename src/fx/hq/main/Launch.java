package fx.hq.main;

import org.springframework.context.ApplicationContext;

import fx.hq.spring.BeanFactory;

public class Launch {
	public static void main(String[] args) {
		Launch launch = new Launch();
		launch.launch();
	}
	
	public void launch() {
		ApplicationContext context = BeanFactory.getApplicationContext();
		ApplicationFX application = (ApplicationFX) context.getBean("application");
	}
}
