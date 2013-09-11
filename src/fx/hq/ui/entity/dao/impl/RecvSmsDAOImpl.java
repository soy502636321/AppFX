package fx.hq.ui.entity.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fx.hq.ui.entity.RecvSms;
import fx.hq.ui.entity.dao.RecvSmsDAO;

public class RecvSmsDAOImpl extends HibernateDaoSupport implements RecvSmsDAO {
	@Override
	public void save(RecvSms recvSms) {
		getHibernateTemplate().save(recvSms);
	}
	
	@Override
	public List findAll() {
		return getHibernateTemplate().loadAll(RecvSms.class);
	}
}
