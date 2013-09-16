package fx.hq.task;

import fx.hq.sms.SmsUtil;

public class ReceiveSmsTask {
	private SmsUtil smsUtil;

	public void run() {
		//接受短信
		getSmsUtil().receive();
	}

	public SmsUtil getSmsUtil() {
		return smsUtil;
	}

	public void setSmsUtil(SmsUtil smsUtil) {
		this.smsUtil = smsUtil;
	}

}
