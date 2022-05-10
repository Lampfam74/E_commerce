package sn.lamp.Ecommerce.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import sn.lamp.Ecommerce.model.ProductImages;
import sn.lamp.Ecommerce.model.Products;
import sn.lamp.Ecommerce.repository.productRepository;
import sn.lamp.Ecommerce.service.productImagesService;
import sn.lamp.Ecommerce.service.productService;

@Service
@Transactional
public  class productServiceImpl implements productService {
	@Autowired
	private productRepository productRepository;
	@Autowired
	private uploadServiceIpml upload;
	@Autowired
	private productImagesService imagesService; 

	@Override
	public Products saveProduct(Products prod) throws Exception {
		if (prod == null)
			return null;
//	
		for(MultipartFile file:prod.getFiles()) {
		
		String fil = file.getOriginalFilename();
		String fileName = FilenameUtils.getBaseName(fil) + "." + FilenameUtils.getExtension(fil);
		File path = upload.getPathService(fileName,"img");
		if (path != null) {
			try {
				FileUtils.writeByteArrayToFile(path, file.getBytes());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
//		ProductImages pImage=new ProductImages();
//		pImage.setImages(fil);
//		pImage.setProducts(prod);
//		 imagesService.save(pImage); 
		 prod.setLogo(fil);
		}
		
		
		return 	productRepository.save(prod);
		
	}

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Products findByCode(String code) {
		if (code == null)
			return null;
		return productRepository.findBycode(code);
	}

	@Override
	public Products findById(Long id) {
		if (id == null)
			return null;
		return productRepository.findById(id).get();
	}

	@Override
	public void suppression(Long id) throws Exception {
		productRepository.deleteById(id);

	}

	@Override
	public Page<Products> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
		     Sort.by(sortField).descending();
		 
		    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		    return this.productRepository.findAll(pageable);
	}

}
