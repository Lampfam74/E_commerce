package sn.lamp.Ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.lamp.Ecommerce.model.Products;
import sn.lamp.Ecommerce.service.productService;

@Controller
@RequestMapping("/panier")
public class PanierController {
	@Autowired
	private  productService productservice;
	private 	List<Products> products = new ArrayList<>();
	@GetMapping("/ajouter/{id}")
	public String editProduct(@PathVariable("id") Long id, Model m) {
	
		products.add(productservice.findById(id));
		m.addAttribute("product", products);
		m.addAttribute("count",products.size());
		products.forEach(element->System.out.println(element.getLibelle()));
		
		return "redirect:/";
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
}
