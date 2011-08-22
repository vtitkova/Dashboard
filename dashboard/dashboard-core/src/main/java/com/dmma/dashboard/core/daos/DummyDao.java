package com.dmma.dashboard.core.daos;

import com.dmma.base.app.daos.base.BaseDao;
import com.dmma.dashboard.core.entities.Dummy;

public class DummyDao  extends BaseDao<Dummy, Integer>{
	
	public DummyDao() {
		super(Dummy.class);
	}
	
}
