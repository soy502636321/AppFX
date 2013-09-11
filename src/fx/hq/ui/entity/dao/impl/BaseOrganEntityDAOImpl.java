package fx.hq.ui.entity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fx.hq.ui.entity.BaseOrganEntity;
import fx.hq.ui.entity.dao.BaseOrganEntityDAO;

public class BaseOrganEntityDAOImpl extends HibernateDaoSupport implements BaseOrganEntityDAO{
	private static Map<String, String> map = null;
	@Override
	public Map<String, String> findMap() {
		if (map == null || map.size() == 0) {
			String hql = "from BaseOrganEntity as b";
			List<BaseOrganEntity> baseOrganEntities = getHibernateTemplate().find(hql);
			if (baseOrganEntities != null) {
				map = new HashMap<String, String>();
				for (BaseOrganEntity baseOrganEntity : baseOrganEntities) {
					System.out.println(baseOrganEntity.getOrganPid() + "-" + baseOrganEntity.getOrganSms() + "-" + baseOrganEntity.getRemark());
					map.put(baseOrganEntity.getOrganPid(), baseOrganEntity.getOrganSms());
				}
			}
		}
		return map;
	}
	
}
