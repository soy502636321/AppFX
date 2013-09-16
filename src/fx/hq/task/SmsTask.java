package fx.hq.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mobset.smsSDK;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import fx.hq.sms.SmsSender;
import fx.hq.sms.SmsUtil;
import fx.hq.spring.BeanFactory;
import fx.hq.ui.entity.SmsEntity;

public class SmsTask {
	private SmsUtil smsUtil;
	
	public void run() {
		//获得发送的短信集合
		List<SmsEntity> entities = BeanFactory.getSmsEntityDAO().findSmsEntities();
		//调用接口发送
		if (entities != null && entities.size() > 0) {
			getSmsUtil().send(entities);
		}
	}

	public SmsUtil getSmsUtil() {
		return smsUtil;
	}

	public void setSmsUtil(SmsUtil smsUtil) {
		this.smsUtil = smsUtil;
	}
	
	
}
