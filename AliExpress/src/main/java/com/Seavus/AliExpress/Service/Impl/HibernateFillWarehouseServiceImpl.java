package com.Seavus.AliExpress.Service.Impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;

@Service
@Transactional
public class HibernateFillWarehouseServiceImpl implements
		HibernateWarehouseService {

	@Autowired
	public HibernateFillWarehouseDao hibernateDao;

	
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
