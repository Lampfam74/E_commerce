package sn.lamp.Ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import sn.lamp.Ecommerce.model.Products;

public interface productService {
	Products saveProduct(Products prod) throws Exception;

	List<Products> findAll();

	Products findByCode(String code);

	Products findById(Long id);
	void suppression( Long id)throws Exception;
	 Page< Products > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
