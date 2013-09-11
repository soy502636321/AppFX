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
				BeanFactory.debug(getCommon() + "��¼�ɹ�");
				break;
			case -1:
				BeanFactory.debug(getCommon() + "���ӷ�����ʧ��");
				break;
			case -2:
				BeanFactory.debug(getCommon() + "��¼��ʱ");
				break;
			case -3:
				BeanFactory.debug(getCommon() + "��¼ʧ�ܣ��ʺ�����");
				break;
			case -4:
				BeanFactory.debug(getCommon() + "��¼ʧ�ܣ���ͬ�ʺ����ڱ𴦵�¼");
				break;
			case -5:
				BeanFactory.debug(getCommon() + "��¼ʧ�ܣ��ʺŹ���Ƶ����¼�����Ժ�����");
				break;
		}
		return i;
	}
	
	public int send(SendMsg[] sendMsg, int iSendCount) {
		int i = getSmsSDK().Sms_Send(sendMsg, iSendCount);
		if (i >= 0) {
			BeanFactory.debug(getCommon() + "�ύ���ţ���������" + iSendCount);
			postProcessing(sendMsg);
		} else if (i == -1) {
			BeanFactory.debug(getCommon() + "��δ��ʼ����");
			connect();
		} else if (i == -2) {
			BeanFactory.debug(getCommon() + "���ͳ�ʱ��");
		} else if (i == -3) {
			BeanFactory.debug(getCommon() + "��ʧ�ܣ��������ʺŹ��ڻ����㣡");
		} else if (i == -4) {
			BeanFactory.debug(getCommon() + "����ʧ�ܣ����͵���Ϣ�����к������йؼ��֣���ֹ���ͣ�");
		} else if (i == -5) {
			BeanFactory.debug(getCommon() + "����ʧ�ܣ����͵�Ŀ�����Ϊ�������û�����ֹ���ͣ�");
		} else {
			BeanFactory.debug(getCommon() + "����ʧ�ܣ��������[" + i + "]");
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
				
				System.out.println("���ӵ������ʾ");
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
