package com.Seavus.AliExpress.Service.Impl;

import com.Seavus.AliExpress.Dao.FillWarehouseDao;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.Dao.Impl.FillWarehouseImpl;

public class FillServiceImpl implements FillWarehouseService {

	public FillWarehouseDao warehouseDao = new FillWarehouseImpl();
	
	@Override
	public void fillWarehouse() {
		warehouseDao.fillWarehouse();
	}

}
