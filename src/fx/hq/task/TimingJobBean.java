package fx.hq.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TimingJobBean extends QuartzJobBean {
	private SmsTask smsTask;
	private ReceiveSmsTask receiveSmsTask;

	@Override
	protected void executeInternal(JobExecutionContext executionContext)
			throws JobExecutionException {
		getSmsTask().run();
		getReceiveSmsTask().run();
	}

	public SmsTask getSmsTask() {
		return smsTask;
	}

	public void setSmsTask(SmsTask smsTask) {
		this.smsTask = smsTask;
	}

	public ReceiveSmsTask getReceiveSmsTask() {
		return receiveSmsTask;
	}

	public void setReceiveSmsTask(ReceiveSmsTask receiveSmsTask) {
		this.receiveSmsTask = receiveSmsTask;
	}

}
