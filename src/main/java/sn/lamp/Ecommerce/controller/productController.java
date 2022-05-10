package sn.lamp.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sn.lamp.Ecommerce.model.Products;
import sn.lamp.Ecommerce.service.categorieService;
import sn.lamp.Ecommerce.service.productService;
	

@Controller
@RequestMapping("/product")
public class productController {

	@Autowired
	private productService productservice;
	@Autowired
	private categorieService categorieservice;

	@GetMapping("/all")
	public String getAllProduct(Model M) {

		M.addAttribute("products", productservice.findAll());

		return "admin/listProduct";
	}

	@PostMapping("/add")
	public String saveProduct(@ModelAttribute("product") Products C,
			Model M) throws Exception {
			productservice.saveProduct(C);
			M.addAttribute("products", productservice.findAll());
	
		return "redirect:/product/all";

	}

	@GetMapping(value = "/new")
	public String addProduct(Model model) {
		Products product = new Products();
		model.addAttribute("product", product);
		model.addAttribute("categories", categorieservice.findAll());
		return "admin/addProduct";

	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model m) {
		m.addAttribute("product", productservice.findById(id));
		m.addAttribute("categories", categorieservice.findAll());
		return "admin/addProduct";
	}

	@GetMapping("supp/{id}")
	public String supp(@PathVariable("id") Long id, Model model) throws Exception {

		productservice.suppression(productservice.findById(id).getId());
		model.addAttribute("products", productservice.findAll());
		return "redirect:/product/all";

	}
	

}
