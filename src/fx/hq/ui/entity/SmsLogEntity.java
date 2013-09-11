package fx.hq.ui.entity;

import java.util.Date;

public class SmsLogEntity {
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
	private int result;
	
	public SmsLogEntity() {
	}

	public SmsLogEntity(String taskId, String mobilePhone, String content,
			Date sendTime, String userKey, String comEmpId, String msgType,
			String userId, String userName, String organPid, String linkMan,
			int result) {
		this.taskId = taskId;
		this.mobilePhone = mobilePhone;
		this.content = content;
		this.sendTime = sendTime;
		this.userKey = userKey;
		this.comEmpId = comEmpId;
		this.msgType = msgType;
		this.userId = userId;
		this.userName = userName;
		this.organPid = organPid;
		this.linkMan = linkMan;
		this.result = result;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
