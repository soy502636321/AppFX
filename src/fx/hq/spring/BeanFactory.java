package fx.hq.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TextArea;

import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.mchange.v2.c3p0.PooledDataSource;

import fx.hq.main.ApplicationFX;
import fx.hq.ui.center.ReceiveSmsTableView;
import fx.hq.ui.entity.dao.BaseOrganEntityDAO;
import fx.hq.ui.entity.dao.RecvSmsDAO;
import fx.hq.ui.entity.dao.SmsEntityDAO;
import fx.hq.ui.entity.dao.SmsLogEntityDAO;

public class BeanFactory {
	private static final String SPRING_CONFIG_NAME = "applicationContext-*.xml";
	private static ApplicationContext context;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	
	private BeanFactory() {
	}
	
	public static ApplicationContext getApplicationContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("applicationContext-common.xml", "applicationContext-sms.xml", "applicationContext-task.xml", "applicationContext-ui.xml");
		}
		return context;
	}
	
	public static ApplicationFX getApplicationFX() {
		ApplicationFX applicationFX = (ApplicationFX) getApplicationContext().getBean("application");
		return applicationFX;
	}
	
	public static SmsEntityDAO getSmsEntityDAO() {
		SmsEntityDAO smsEntityDAO = (SmsEntityDAO) getApplicationContext().getBean("smsEntityDAO");
		return smsEntityDAO;
	}
	
	public static BaseOrganEntityDAO getBaseOrganEntityDAO() {
		BaseOrganEntityDAO baseOrganEntityDAO = (BaseOrganEntityDAO) getApplicationContext().getBean("baseOrganEntityDAO");
		return baseOrganEntityDAO;
	}
	
	public static StdScheduler getStdScheduler() {
		StdScheduler scheduler = (StdScheduler) getApplicationContext().getBean("schedulerFactoryBean");
		return scheduler;
	}
	
	public static void shutDown() {
		BeanFactory.getStdScheduler().shutdown();
	}
	
	public static TextArea getTextArea() {
		TextArea textArea = (TextArea) BeanFactory.getApplicationContext().getBean("textArea");
		return textArea;
	}
	
	public static void debug(String msg) {
		TextArea textArea = BeanFactory.getTextArea();
		if (textArea != null) {
			String string = textArea.getText();
			string += getDate() + ":" + (msg == null ? "" : msg) + "\n";
			textArea.setText(string);
			textArea.setScrollTop(Double.MAX_VALUE);
		}
	}
	
	public static SmsLogEntityDAO getSmsLogEntityDAO() {
		SmsLogEntityDAO smsLogEntityDAO = (SmsLogEntityDAO) getApplicationContext().getBean("smsLogEntityDAO");
		return smsLogEntityDAO;
	}
	
	public static RecvSmsDAO getRecvSmsDAO() {
		RecvSmsDAO recvSmsDAO = (RecvSmsDAO) getApplicationContext().getBean("recvSmsDAO");
		return recvSmsDAO;
	}
	
	public static String getDate() {
		return dateFormat.format(new Date());
	}

	public static ReceiveSmsTableView getReceiveSmsTableView() {
		ReceiveSmsTableView receiveSmsTableView = (ReceiveSmsTableView) getApplicationContext().getBean("receiveSmsTableView");
		return receiveSmsTableView;
	}
}
