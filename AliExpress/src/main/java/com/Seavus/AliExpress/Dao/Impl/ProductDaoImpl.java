package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.JDBC.JDBCDaoTemplate;
import com.Seavus.AliExpress.Templates.JDBC.ProductByIdSetter;
import com.Seavus.AliExpress.Templates.JDBC.ProductListSetter;
import com.Seavus.AliExpress.Templates.JDBC.ProductRegisterSetter;
import com.Seavus.AliExpress.Templates.JDBC.ProductUnregisterSetter;
import com.Seavus.AliExpress.Templates.JDBC.ProductUpdateSetter;

public class ProductDaoImpl implements ProductDao {

	public JDBCDaoTemplate template = new JDBCDaoTemplate();

	public Product getProductById(String id) {
		return template.executeProduct(new ProductByIdSetter(id));
	}

	public List<Product> listAllProducts() {
		return template.executeList(new ProductListSetter());
	}

	public void addProduct(Product p) {
		template.execute(new ProductRegisterSetter(p));
	}

	public void removeProduct(String id) {
		template.execute(new ProductUnregisterSetter(id));
	}

	public void updateProduct(Product p) {
		template.execute(new ProductUpdateSetter(p));
	}

}
