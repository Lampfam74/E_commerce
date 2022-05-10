package sn.lamp.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import sn.lamp.Ecommerce.model.Products;
import sn.lamp.Ecommerce.service.categorieService;
import sn.lamp.Ecommerce.service.productService;

@Controller
public class AccueilController {
	@Autowired
	private productService productservice;
	@Autowired
	private categorieService categorieservice;

	@GetMapping("/")
	public String index(Model M) {
		M.addAttribute("products", productservice.findAll());
		M.addAttribute("categories", categorieservice.findAll());
		return findPaginated(1, "libelle", "asc",M);
//		return "accueil/index";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Products> page = productservice.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Products> listProducts = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("products", listProducts);
		return "accueil/index";
	}
}
