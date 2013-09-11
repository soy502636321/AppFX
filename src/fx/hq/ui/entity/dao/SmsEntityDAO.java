package fx.hq.ui.entity.dao;

import java.util.List;

import fx.hq.ui.entity.SmsEntity;

public interface SmsEntityDAO {
	public List<SmsEntity> findSmsEntities();

	public SmsEntity delete(String taskId);
}
