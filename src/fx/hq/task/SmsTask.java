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
		List<SmsEntity> entities = BeanFactory.getSmsEntityDAO().findSmsEntities();
		//获得发送集合
//		System.out.println("发送数量:" + entities.size());
//		System.out.println("任务线程:" + Thread.currentThread().getName());
//		System.out.println("SDK对象-SC:" + getSmsUtil().getScSmsSender());
//		System.out.println("SDK对象-JH:" + getSmsUtil().getJhSmsSender());
//		System.out.println("SDK对象-RL:" + getSmsUtil().getRlSmsSender());
		//发送
		if (entities != null && entities.size() > 0) {
			getSmsUtil().send(entities);
		}
		System.out.println("查询发送");
//		SmsSender scSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("scSmsSender");
//		SmsSender rlSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("rlSmsSender");
//		SmsSender jhSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("jhSmsSender");
//		scSmsSender.connect();
//		rlSmsSender.connect();
//		jhSmsSender.connect();
//		System.out.println("当前主线程:" + Thread.currentThread().getName());
//		System.out.println("--SC:" + scSmsSender.getSmsSDK());
//		System.out.println("--RL:" + rlSmsSender.getSmsSDK());
//		System.out.println("--JH:" + jhSmsSender.getSmsSDK());
//		while (true) {
//			try {
//				Thread.currentThread().sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("启动一次");
//			int i = getSmsUtil().getScSmsSender().getStatus(80431);
//			System.out.println("查询状态:" + i);
//		}
//		
//		smsSDK sdk = new smsSDK();
//		int i = sdk.Sms_Connect("www.mobset.com", 112356, "sc", "156832", 30);
//		System.out.println("登录状态:" + i);
//		
//		while (true) {
//		int result = sdk.Sms_Status(80431);
//			if (result == -1) {
//				sdk.Sms_Connect("www.mobset.com", 112356, "sc", "156832", 30);
//				result = sdk.Sms_Status(80431);
//			}
//			System.out.println(result);
//		try {
//			Thread.currentThread().sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//		str_SendMsg sendMsg = new str_SendMsg();
//		sendMsg.strMobile = "15976812172";
//		sendMsg.strMsg = "测试查看状态 !!";
//		str_SendMsg[] sendMsgs = new str_SendMsg[] {
//			sendMsg
//		};
//		int result = sdk.Sms_Send(sendMsgs, 1);
//		System.out.println("第一次发送状态:" + result);
//		
//		sendMsg = new str_SendMsg();
//		sendMsg.strMobile = "13580500449";
//		sendMsg.strMsg = "同时发送";
//		sendMsgs = new str_SendMsg[] {
//				sendMsg
//		};
//		int i = sdk.Sms_Send(sendMsgs, 1);
//		System.out.println("第二次发送状态:" + i);
	}

	public SmsUtil getSmsUtil() {
		return smsUtil;
	}

	public void setSmsUtil(SmsUtil smsUtil) {
		this.smsUtil = smsUtil;
	}
	
	
}
