package fx.hq.ui.entity.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fx.hq.ui.entity.SmsEntity;
import fx.hq.ui.entity.SmsLogEntity;
import fx.hq.ui.entity.dao.SmsLogEntityDAO;

public class SmsLogEntityDAOImpl extends HibernateDaoSupport implements
		SmsLogEntityDAO {
	@Override
	public void save(SmsEntity entity, int result) {
		try {
			if (entity != null) {
				String taskId = entity.getTaskId();
				String mobilePhone = entity.getMobilePhone();
				String content = entity.getContent();
				SmsLogEntity logEntity = new SmsLogEntity(taskId,
						mobilePhone, content,
						entity.getSendTime(), entity.getUserKey(),
						entity.getComEmpId(), entity.getMsgType(),
						entity.getUserId(), entity.getUserName(),
						entity.getOrganPid(), entity.getLinkMan(), result);
				getHibernateTemplate().save(logEntity);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
