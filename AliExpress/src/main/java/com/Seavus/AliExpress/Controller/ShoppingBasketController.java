package com.Seavus.AliExpress.Controller;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.ShoppingBasketService;

public class ShoppingBasketController {

	public ShoppingBasketService service;

	public UI input;

	public Output output;

	public ProductService productService;

	public ShoppingBasketController(ShoppingBasketService service,
			ProductService productService, UI input, Output output) {
		this.productService = productService;
		this.service = service;
		this.input = input;
		this.output = output;
	}

	public void addProductsToBasket() {
		HashMap<String, Integer> map = output.addProductsToBasket(input,
				productService);
		service.addBasket();
		ShoppingBasket basket = service.getNewestBasket();
		int sum = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			Product p = productService.getProductById(entry.getKey());
			sum += entry.getValue() * p.getPrice();
			p.setQuantity(p.getQuantity() - entry.getValue());
			service.addProduct(basket, p, entry.getValue());
			if (p.getQuantity() == 0) {
				productService.removeProduct(p.getId());
			} else {
				productService.updateProduct(p);
			}
		}
		basket.setSum(sum);
		service.updateBasket(basket);
	}

	public void addShoppingBasket() {
		service.addBasket();
	}

	public Set<Product> listAllProducts() {
		return service.listAllProducts(service.getNewestBasket());
	}

	public int getSum() {
		return service.getSum(service.getNewestBasket());
	}

}
