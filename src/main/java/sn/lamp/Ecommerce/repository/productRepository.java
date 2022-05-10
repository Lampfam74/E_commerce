package sn.lamp.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import sn.lamp.Ecommerce.model.Products;



public interface productRepository extends JpaRepository<Products, Long> {
	Products findBycode(String code);

}
