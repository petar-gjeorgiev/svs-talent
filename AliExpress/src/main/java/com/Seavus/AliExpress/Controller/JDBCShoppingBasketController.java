package com.Seavus.AliExpress.Controller;

import java.util.HashMap;
import java.util.Map.Entry;

import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.ShoppingBasketService;
import com.Seavus.AliExpress.Service.Impl.ProductServiceImpl;
import com.Seavus.AliExpress.Service.Impl.ShoppingBasketServiceImpl;

public class JDBCShoppingBasketController {

	public ShoppingBasketService service = new ShoppingBasketServiceImpl();

	public UI input = Factory.Input();

	public Output output = new Output();

	public ProductService productService = new ProductServiceImpl();

	public void addProductsToBasket() {
		HashMap<String, Integer> map = output.addProductsToBasket(input,
				productService);
		ShoppingBasket basket = service.getNewestBasket();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Product p = productService.getProductById(entry.getKey());
			p.setQuantity(entry.getValue());
			service.addProduct(basket, p);
		}
	}

	public void addShoppingBasket() {
		service.addBasket();
	}

	public void listAllProducts() {
		service.listAllProducts(service.getNewestBasket());
	}

}
