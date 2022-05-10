package sn.lamp.Ecommerce.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.lamp.Ecommerce.model.Categorie;
import sn.lamp.Ecommerce.service.categorieService;

@Controller
@RequestMapping("/categorie")
public class categorieController {
	@Autowired
	private categorieService categorieService;
	
	@GetMapping("/all")
	public String getAllProduct(Model M){
	
		M.addAttribute("categories", categorieService.findAll());
		return"admin/accueil";
	}
	@PostMapping("/add")
	public String saveCategorie(@ModelAttribute("categorie")Categorie C,Model M) throws Exception {
		categorieService.saveCategorie(C);
		M.addAttribute("categories", categorieService.findAll());
		return "redirect:/categorie/all";
		
	}
	@GetMapping(value = "/new")
	public String CreateUtilisateur(Model model) {
		Categorie categorie=new Categorie();
		model.addAttribute("categorie",categorie);
		return "admin/add";
	
	}
	@GetMapping("/edit/{id}")
	public String editUtilisateur(@PathVariable Long id,Model m) {
		m.addAttribute("categorie", categorieService.findById(id));
		return "admin/add";
	}
	@GetMapping("supp/{id}")
	public String supp(@PathVariable Long id,Model model) throws Exception {
		Categorie cat=categorieService.findById(id);
		categorieService.suppression(cat.getId());
		model.addAttribute("categories", categorieService.findAll());
		return "redirect:/categorie/all";
	}
}
