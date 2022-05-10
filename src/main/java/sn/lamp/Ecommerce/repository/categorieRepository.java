package sn.lamp.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.Ecommerce.model.Categorie;

@Repository
public interface categorieRepository extends JpaRepository<Categorie, Long>{
	Categorie findByCode(String code);

}
