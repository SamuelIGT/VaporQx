package br.ufc.quixada.samuel.vaporqx.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.samuel.vaporqx.model.Product;

public interface ProductService {
	Product saveProduct(Product product, MultipartFile image);
	
	Product getProduct(Long id);
	
	void removeProduct(Long id);
	
	List<Product> findAll();
}
