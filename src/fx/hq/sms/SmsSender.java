package fx.hq.sms;

import org.springframework.context.annotation.Bean;

import fx.hq.spring.BeanFactory;
import fx.hq.ui.center.SendSmsTableView;
import fx.hq.ui.entity.SmsEntity;
import mobset.smsSDK;
import mobset.str_RecvMsg;

public class SmsSender {
	private smsSDK smsSDK = new smsSDK();
	private String strHost;
	private int iCorpID;
	private String strLoginName;
	private String strPasswd;
	private int iTimeOut;
	
	private String common;

	public static void main(String[] args) {
		smsSDK smsSDK = new smsSDK();
		int i = smsSDK.Sms_Connect("www.mobset.com", 112356, "jh", "185119", 30);
		System.out.println(i);
	}

	public int connect() {
		int i = getSmsSDK().Sms_Connect(strHost, iCorpID, strLoginName,
				strPasswd, iTimeOut);
		switch(i) {
			case 0: 
				BeanFactory.debug(getCommon() + "登录成功");
				break;
			case -1:
				BeanFactory.debug(getCommon() + "连接服务器失败");
				break;
			case -2:
				BeanFactory.debug(getCommon() + "登录超时");
				break;
			case -3:
				BeanFactory.debug(getCommon() + "登录失败，帐号有误");
				break;
			case -4:
				BeanFactory.debug(getCommon() + "登录失败，相同帐号已在别处登录");
				break;
			case -5:
				BeanFactory.debug(getCommon() + "登录失败，帐号过于频繁登录，请稍后再试");
				break;
		}
		return i;
	}
	
	public int send(SendMsg[] sendMsg, int iSendCount) {
		int i = getSmsSDK().Sms_Send(sendMsg, iSendCount);
		if (i >= 0) {
			BeanFactory.debug(getCommon() + "提交短信，总数量：" + iSendCount);
			postProcessing(sendMsg);
		} else if (i == -1) {
			BeanFactory.debug(getCommon() + "还未初始化！");
			connect();
		} else if (i == -2) {
			BeanFactory.debug(getCommon() + "发送超时！");
		} else if (i == -3) {
			BeanFactory.debug(getCommon() + "送失败，可能是帐号过期或余额不足！");
		} else if (i == -4) {
			BeanFactory.debug(getCommon() + "发送失败，发送的信息内容中含有敏感关键字，禁止发送！");
		} else if (i == -5) {
			BeanFactory.debug(getCommon() + "发送失败，发送的目标号码为黑名单用户，禁止发送！");
		} else {
			BeanFactory.debug(getCommon() + "发送失败，错误代码[" + i + "]");
		}
		return i;
	}
	
	public int receive(ReceiveMsg receiveMsg) {
		return getSmsSDK().Sms_Get(receiveMsg);
	}
	
	public void postProcessing(SendMsg[] sendMsg) {
		if (sendMsg != null && sendMsg.length > 0) {
			for (SendMsg msg : sendMsg) {
				System.out.println("1");
				SmsEntity entity = BeanFactory.getSmsEntityDAO().delete(msg.taskId);
				int result = getStatus(msg.iSmsID);
				System.out.println(2);
				entity.setComEmpId(msg.userKey);
				System.out.println(3);
				BeanFactory.getSmsLogEntityDAO().save(entity, result);
				System.out.println(4);
				
				System.out.println("增加到表格显示");
				SendSmsTableView sendSmsTableView = (SendSmsTableView) BeanFactory.getApplicationContext().getBean("sendSmsTableView");
				sendSmsTableView.getItems().add(entity);
			}
		}
	}
	
	public int getStatus(int iMsgID) {
		int i = getSmsSDK().Sms_Status(iMsgID);
		if (i == -1) {
			connect();
			i = getSmsSDK().Sms_Status(iMsgID);
		}
		return i;
	}
	
	public void disConnect() {
		getSmsSDK().Sms_DisConnect();
	}

	public smsSDK getSmsSDK() {
		return smsSDK;
	}

	public void setSmsSDK(smsSDK smsSDK) {
		this.smsSDK = smsSDK;
	}

	public String getStrHost() {
		return strHost;
	}

	public void setStrHost(String strHost) {
		this.strHost = strHost;
	}

	public int getiCorpID() {
		return iCorpID;
	}

	public void setiCorpID(int iCorpID) {
		this.iCorpID = iCorpID;
	}

	public String getStrLoginName() {
		return strLoginName;
	}

	public void setStrLoginName(String strLoginName) {
		this.strLoginName = strLoginName;
	}

	public String getStrPasswd() {
		return strPasswd;
	}

	public void setStrPasswd(String strPasswd) {
		this.strPasswd = strPasswd;
	}

	public int getiTimeOut() {
		return iTimeOut;
	}

	public void setiTimeOut(int iTimeOut) {
		this.iTimeOut = iTimeOut;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

}
