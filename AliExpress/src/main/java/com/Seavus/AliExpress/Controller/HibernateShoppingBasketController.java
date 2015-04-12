package com.Seavus.AliExpress.Controller;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;

public class HibernateShoppingBasketController {

	public HibernateShoppingBasketService service;

	public UI input;

	public Output output;

	public HibernateProductService productService;

	public HibernateShoppingBasketController(
			HibernateShoppingBasketService service,
			HibernateProductService productService, UI input, Output output) {
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
			service.addProduct(basket, p, entry.getValue());
			p.setQuantity(p.getQuantity() - entry.getValue());
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

	public void closeBasketFactory() {
		service.closeFactory();
	}

	public void setBasketFactory(SessionFactory factory) {
		service.setFactory(factory);
	}

	public void closeProductFactory() {
		productService.closeFactory();
	}

	public void setProductFactory(SessionFactory factory) {
		productService.setFactory(factory);
	}

}
