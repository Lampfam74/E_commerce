package sn.lamp.Ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.Ecommerce.model.Categorie;
import sn.lamp.Ecommerce.repository.categorieRepository;
import sn.lamp.Ecommerce.service.categorieService;


@Service
public class categorieServiceImpl implements categorieService {
	@Autowired
private categorieRepository categorieRepository;
	@Override
	public void saveCategorie(Categorie cat) throws Exception {
		
		 categorieRepository.save(cat);
		 
	}

	@Override
	public List<Categorie> findAll() {
		
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findByCode(String code) {
		if(code==null)
			return null;
		return categorieRepository.findByCode(code);
	}

	@Override
	public Categorie findById(Long id) {
		if(id==null)
			return null;
		return categorieRepository.findById(id).get();
	}

	@Override
	public void suppression(Long id) {
		categorieRepository.deleteById(id);
		
	}

}
