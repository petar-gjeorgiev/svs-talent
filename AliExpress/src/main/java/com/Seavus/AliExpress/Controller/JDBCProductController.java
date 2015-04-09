package com.Seavus.AliExpress.Controller;

import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.Impl.FillWarehouseServiceImpl;
import com.Seavus.AliExpress.Service.Impl.ProductServiceImpl;

public class JDBCProductController {

	public ProductService service = new ProductServiceImpl();

	public FillWarehouseService warehouseService = new FillWarehouseServiceImpl();

	public Output output = new Output();

	public UI input = Factory.Input();

	public void registerProduct() {
		service.addProduct(output.registerProduct(input));
	}

	public void updateProduct() {
		service.updateProduct(output.updateProduct(input));
	}

	public void unregisterProduct() {
		service.removeProduct(output.removeProduct(input));
	}

	public void listProducts() {
		StringBuilder sb = new StringBuilder();
		String name = "NAME";
		String price = "PRICE";
		String id = "ID";
		sb.append(String.format("%2s %10s %5s", id, name, price) + "\n");
		for (Product p : service.listAllProducts()) {
			sb.append(p + "\n");
		}
		System.out.println(sb.toString());
		
		System.out.println("\n\n");
		AppInfo.appInfo();
	}

	public void fillWarehouse() {
		warehouseService.fillWarehouse();
	}
}
