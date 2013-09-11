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
		//��÷��ͼ���
//		System.out.println("��������:" + entities.size());
//		System.out.println("�����߳�:" + Thread.currentThread().getName());
//		System.out.println("SDK����-SC:" + getSmsUtil().getScSmsSender());
//		System.out.println("SDK����-JH:" + getSmsUtil().getJhSmsSender());
//		System.out.println("SDK����-RL:" + getSmsUtil().getRlSmsSender());
		//����
		if (entities != null && entities.size() > 0) {
			getSmsUtil().send(entities);
		}
		System.out.println("��ѯ����");
//		SmsSender scSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("scSmsSender");
//		SmsSender rlSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("rlSmsSender");
//		SmsSender jhSmsSender = (SmsSender) BeanFactory
//				.getApplicationContext().getBean("jhSmsSender");
//		scSmsSender.connect();
//		rlSmsSender.connect();
//		jhSmsSender.connect();
//		System.out.println("��ǰ���߳�:" + Thread.currentThread().getName());
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
//			System.out.println("����һ��");
//			int i = getSmsUtil().getScSmsSender().getStatus(80431);
//			System.out.println("��ѯ״̬:" + i);
//		}
//		
//		smsSDK sdk = new smsSDK();
//		int i = sdk.Sms_Connect("www.mobset.com", 112356, "sc", "156832", 30);
//		System.out.println("��¼״̬:" + i);
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
//		sendMsg.strMsg = "���Բ鿴״̬ !!";
//		str_SendMsg[] sendMsgs = new str_SendMsg[] {
//			sendMsg
//		};
//		int result = sdk.Sms_Send(sendMsgs, 1);
//		System.out.println("��һ�η���״̬:" + result);
//		
//		sendMsg = new str_SendMsg();
//		sendMsg.strMobile = "13580500449";
//		sendMsg.strMsg = "ͬʱ����";
//		sendMsgs = new str_SendMsg[] {
//				sendMsg
//		};
//		int i = sdk.Sms_Send(sendMsgs, 1);
//		System.out.println("�ڶ��η���״̬:" + i);
	}

	public SmsUtil getSmsUtil() {
		return smsUtil;
	}

	public void setSmsUtil(SmsUtil smsUtil) {
		this.smsUtil = smsUtil;
	}
	
	
}
