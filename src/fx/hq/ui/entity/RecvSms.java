package fx.hq.ui.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecvSms {
	private Integer recID;
	private String smsContent;
	private Date smsTime;
	private String smsCaller;
	private String readerAgentID;
	private String organSms;
	private String smsTimeString;
	private String receOrgan;

	public RecvSms() {
	}

	public RecvSms(Integer recID, String smsContent, Date smsTime,
			String smsCaller, String readerAgentID, String organSms) {
		this.recID = recID;
		this.smsContent = smsContent;
		this.smsTime = smsTime;
		this.smsCaller = smsCaller;
		this.readerAgentID = readerAgentID;
		this.organSms = organSms;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public Date getSmsTime() {
		return smsTime;
	}

	public void setSmsTime(Date smsTime) {
		this.smsTime = smsTime;
	}

	public String getSmsCaller() {
		return smsCaller;
	}

	public void setSmsCaller(String smsCaller) {
		this.smsCaller = smsCaller;
	}

	public String getReaderAgentID() {
		return readerAgentID;
	}

	public void setReaderAgentID(String readerAgentID) {
		this.readerAgentID = readerAgentID;
	}

	public Integer getRecID() {
		return recID;
	}

	public void setRecID(Integer recID) {
		this.recID = recID;
	}

	public String getOrganSms() {
		return organSms;
	}

	public void setOrganSms(String organSms) {
		this.organSms = organSms;
	}

	public String getSmsTimeString() {
		if (getSmsTime() != null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");
			smsTimeString = dateFormat.format(getSmsTime());
		}
		return smsTimeString;
	}

	public void setSmsTimeString(String smsTimeString) {
		this.smsTimeString = smsTimeString;
	}

	public String getReceOrgan() {
		if (getOrganSms() != null) {
			if ("rl".equals(getOrganSms())) {
				setReceOrgan("����");
			} else if ("sc".equals(getOrganSms())) {
				setReceOrgan("�г�");
			} else if ("jh".equals(getOrganSms())) {
				setReceOrgan("�ƻ�");
			}
		}
		return receOrgan;
	}

	public void setReceOrgan(String receOrgan) {
		this.receOrgan = receOrgan;
	}

}
