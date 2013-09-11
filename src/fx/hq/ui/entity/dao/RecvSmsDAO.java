package fx.hq.ui.entity.dao;

import java.util.List;

import fx.hq.ui.entity.RecvSms;

public interface RecvSmsDAO {
	public void save(RecvSms recvSms);
	public List findAll();
}
