package sn.lamp.Ecommerce.service;

import java.util.List;

import sn.lamp.Ecommerce.model.Categorie;

public interface categorieService {
	void saveCategorie(Categorie cat) throws Exception;

	List<Categorie> findAll();

	Categorie findByCode(String code);

	Categorie findById(Long id);
	void suppression( Long id)throws Exception;

}
