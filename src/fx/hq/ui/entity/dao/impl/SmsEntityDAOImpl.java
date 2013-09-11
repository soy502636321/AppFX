package fx.hq.ui.entity.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fx.hq.ui.entity.SmsEntity;
import fx.hq.ui.entity.dao.SmsEntityDAO;

public class SmsEntityDAOImpl extends HibernateDaoSupport implements
		SmsEntityDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<SmsEntity> findSmsEntities() {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<SmsEntity>>() {

					@Override
					@SuppressWarnings("unchecked")
					public List<SmsEntity> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuffer hql = new StringBuffer(
								"from SmsEntity as s");
						session.beginTransaction();
						Query query = session.createQuery(hql.toString());
						query.setMaxResults(50);

						List<SmsEntity> smsEntities = query.list();
						session.getTransaction().commit();
						return smsEntities;
					}
				});
	}
	
	@Override
	public SmsEntity delete(String taskId) {
		SmsEntity entity = getHibernateTemplate().get(SmsEntity.class, taskId);
		getHibernateTemplate().delete(entity);
		return entity;
	}
}
