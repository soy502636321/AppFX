package fx.hq.task;

import fx.hq.sms.SmsUtil;

public class ReceiveSmsTask {
	private SmsUtil smsUtil;

	public void run() {
		// System.out.println("���ܶ���");
		System.out.println("�����̣߳�" + Thread.currentThread().getName());
		getSmsUtil().receive();
	}

	public SmsUtil getSmsUtil() {
		return smsUtil;
	}

	public void setSmsUtil(SmsUtil smsUtil) {
		this.smsUtil = smsUtil;
	}

}
