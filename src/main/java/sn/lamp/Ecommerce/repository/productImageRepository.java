package sn.lamp.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.lamp.Ecommerce.model.ProductImages;




public interface productImageRepository extends JpaRepository<ProductImages, Long> {
	

}
