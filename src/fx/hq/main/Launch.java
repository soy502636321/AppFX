package fx.hq.main;

import java.util.Calendar;
import java.util.Date;

import mobset.smsSDK;
import mobset.str_SendMsg;
import fx.hq.spring.BeanFactory;
import fx.hq.ui.entity.SmsEntity;
import fx.hq.ui.entity.dao.SmsLogEntityDAO;

public class Launch {
	public static void main(String[] args) {
		ApplicationFX fx = (ApplicationFX) BeanFactory.getApplicationFX();
		fx.launch();
	}
}
