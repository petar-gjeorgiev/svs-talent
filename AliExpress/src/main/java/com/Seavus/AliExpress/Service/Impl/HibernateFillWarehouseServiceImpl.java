package com.Seavus.AliExpress.Service.Impl;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.Impl.HibernateFillWarehouseImpl;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;

public class HibernateFillWarehouseServiceImpl implements
		HibernateWarehouseService {

	public HibernateFillWarehouseDao hibernateDao = new HibernateFillWarehouseImpl();

	public void fillWarehouse() {
		hibernateDao.fillWarehouse();
	}

	public void setFactory(SessionFactory factory) {
		hibernateDao.setFactory(factory);
	}

	public void closeFactory() {
		hibernateDao.closeFactory();
	}

}
