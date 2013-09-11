package fx.hq.sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import mobset.smsSDK;

import fx.hq.spring.BeanFactory;
import fx.hq.ui.center.ReceiveSmsTableView;
import fx.hq.ui.entity.RecvSms;
import fx.hq.ui.entity.SmsEntity;
import fx.hq.ui.entity.dao.RecvSmsDAO;

public class SmsUtil {
	private SmsSender scSmsSender;
	private SmsSender rlSmsSender;
	private SmsSender jhSmsSender;
	private SmsSender defaultSmsSender;

	public void send(List<SmsEntity> entities) {
		if (entities != null && entities.size() > 0) {
			Map<String, String> map = BeanFactory.getBaseOrganEntityDAO().findMap();
			List<SendMsg> scMsgs = new ArrayList<SendMsg>();
			List<SendMsg> rlMsgs = new ArrayList<SendMsg>();
			List<SendMsg> jhMsgs = new ArrayList<SendMsg>();
			List<SendMsg> defaultMsgs = new ArrayList<SendMsg>();
			for (SmsEntity entity : entities) {
				String organPid = entity.getOrganPid();
				String string = map.get(organPid);
				if ("sc".equals(string)) {
					scMsgs.add(entity.createMsg("sc"));
				} else if ("rl".equals(string)) {
					rlMsgs.add(entity.createMsg("rl"));
				} else if ("jh".equals(string)) {
					jhMsgs.add(entity.createMsg("jh"));
				} else {
					defaultMsgs.add(entity.createMsg("default"));
				}
			}
			BeanFactory.debug("发送短信:人力[" + rlMsgs.size() + "]，市场[" + scMsgs.size() + "]，计划[" + jhMsgs.size() + "]，默认[" + defaultMsgs.size() + "]");
			if (scMsgs.size() > 0) {
				SendMsg[] sendMsgs = new SendMsg[scMsgs.size()];
				scMsgs.toArray(sendMsgs);
				getScSmsSender().send(sendMsgs, scMsgs.size());
			}
			if (jhMsgs.size() > 0) {
				SendMsg[] sendMsgs = new SendMsg[jhMsgs.size()];
				jhMsgs.toArray(sendMsgs);
				getJhSmsSender().send(sendMsgs, jhMsgs.size());
			}
			if (rlMsgs.size() > 0) {
				SendMsg[] sendMsgs = new SendMsg[rlMsgs.size()];
				rlMsgs.toArray(sendMsgs);
				getRlSmsSender().send(sendMsgs, rlMsgs.size());
			}
			if (defaultMsgs.size() > 0) {
				SendMsg[] sendMsgs = new SendMsg[defaultMsgs.size()];
				defaultMsgs.toArray(sendMsgs);
				getDefaultSmsSender().send(sendMsgs, defaultMsgs.size());
			}
		}
	}
	

	public void receive() {
		RecvSmsDAO recvSmsDAO = (RecvSmsDAO) BeanFactory.getRecvSmsDAO();
		ReceiveMsg scMsg = new ReceiveMsg();
		int scCount = getScSmsSender().receive(scMsg);
		if (scCount >= 0) {
			BeanFactory.debug("市场收到短信");
			RecvSms recvSms = new RecvSms(scMsg.iLogID, scMsg.strMsg, new Date(), scMsg.strSendNum, null, "sc");
			recvSmsDAO.save(recvSms);
			ReceiveSmsTableView receiveSmsTableView = BeanFactory.getReceiveSmsTableView();
			receiveSmsTableView.getItems().add(recvSms);
		}
		
		ReceiveMsg rlMsg = new ReceiveMsg();
		int rlCount = getRlSmsSender().receive(rlMsg);
		if (rlCount >= 0) {
			BeanFactory.debug("人力收到短信");
			RecvSms recvSms = new RecvSms(rlMsg.iLogID, rlMsg.strMsg, new Date(), rlMsg.strSendNum, null, "rl");
			recvSmsDAO.save(recvSms);
			ReceiveSmsTableView receiveSmsTableView = BeanFactory.getReceiveSmsTableView();
			receiveSmsTableView.getItems().add(recvSms);
		}
		
		ReceiveMsg jhMsg = new ReceiveMsg();
		int jhCount = getJhSmsSender().receive(jhMsg);
		if (jhCount >= 0) {
			BeanFactory.debug("计划收到短信");
			RecvSms recvSms = new RecvSms(jhMsg.iLogID, jhMsg.strMsg, new Date(), jhMsg.strSendNum, null, "jh");
			recvSmsDAO.save(recvSms);
			ReceiveSmsTableView receiveSmsTableView = BeanFactory.getReceiveSmsTableView();
			receiveSmsTableView.getItems().add(recvSms);
		}
		
	}

	public SmsSender getScSmsSender() {
		return scSmsSender;
	}

	public void setScSmsSender(SmsSender scSmsSender) {
		this.scSmsSender = scSmsSender;
	}

	public SmsSender getRlSmsSender() {
		return rlSmsSender;
	}

	public void setRlSmsSender(SmsSender rlSmsSender) {
		this.rlSmsSender = rlSmsSender;
	}

	public SmsSender getJhSmsSender() {
		return jhSmsSender;
	}

	public void setJhSmsSender(SmsSender jhSmsSender) {
		this.jhSmsSender = jhSmsSender;
	}

	public SmsSender getDefaultSmsSender() {
		return defaultSmsSender;
	}

	public void setDefaultSmsSender(SmsSender defaultSmsSender) {
		this.defaultSmsSender = defaultSmsSender;
	}
}
