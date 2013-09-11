package fx.hq.sms;

import java.util.Calendar;

import mobset.str_SendMsg;

public class SendMsg extends str_SendMsg {
	public String taskId;
	public String userKey;

	public SendMsg() {
	}

	public SendMsg(String taskId, String strMobile,
			String strMsg, Calendar dTimer, String userKey) {
		this.taskId = taskId;
		this.strMobile = strMobile;
		this.strMsg = strMsg;
		this.dTimer = dTimer;
		this.userKey = userKey;
	}
	
}
