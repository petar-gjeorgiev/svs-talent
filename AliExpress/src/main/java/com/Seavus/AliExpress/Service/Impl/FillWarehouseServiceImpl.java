package com.Seavus.AliExpress.Service.Impl;

import com.Seavus.AliExpress.Dao.FillWarehouseDao;
import com.Seavus.AliExpress.Dao.Impl.FillWarehouseImpl;
import com.Seavus.AliExpress.Service.FillWarehouseService;

public class FillWarehouseServiceImpl implements FillWarehouseService {

	public FillWarehouseDao warehouseDao = new FillWarehouseImpl();
	
	@Override
	public void fillWarehouse() {
		warehouseDao.fillWarehouse();
	}

}
