package com.Seavus.AliExpress.Service.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;

@Service
public class HibernateFillWarehouseServiceImpl implements
		HibernateWarehouseService {

	public HibernateFillWarehouseDao hibernateDao;

	@Autowired
	public HibernateFillWarehouseServiceImpl(HibernateFillWarehouseDao dao) {
		hibernateDao = dao;
	}
	
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
