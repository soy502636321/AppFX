package fx.hq.ui.entity;

import java.util.Calendar;
import java.util.Date;

import fx.hq.sms.SendMsg;

public class SmsEntity {
	private String taskId;
	private String mobilePhone;
	private String content;
	private Date sendTime;
	private String userKey;
	private String comEmpId;
	private String msgType;
	private String userId;
	private String userName;
	private String organPid;
	private String linkMan;

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getComEmpId() {
		return comEmpId;
	}

	public void setComEmpId(String comEmpId) {
		this.comEmpId = comEmpId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganPid() {
		return organPid;
	}

	public void setOrganPid(String organPid) {
		this.organPid = organPid;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public SendMsg createMsg(String userKey) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getSendTime());
		return new SendMsg(this.getTaskId(), this.getMobilePhone(), this.getContent(), calendar, userKey);
	}

}
