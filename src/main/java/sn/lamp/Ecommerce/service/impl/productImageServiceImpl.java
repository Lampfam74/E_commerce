package sn.lamp.Ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sn.lamp.Ecommerce.model.ProductImages;
import sn.lamp.Ecommerce.service.productImagesService;
import sn.lamp.Ecommerce.repository.productImageRepository;
@Service
@Transactional
public  class productImageServiceImpl implements productImagesService {
	@Autowired
	private productImageRepository prodImage;
	
	@Override
	public ProductImages save(ProductImages prodImg) throws Exception {
		// TODO Auto-generated method stub
		return prodImage.save(prodImg);
	}



}
