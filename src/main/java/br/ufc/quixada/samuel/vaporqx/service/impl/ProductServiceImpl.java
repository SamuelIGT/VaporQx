package br.ufc.quixada.samuel.vaporqx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.samuel.vaporqx.model.Product;
import br.ufc.quixada.samuel.vaporqx.repository.ProductRepository;
import br.ufc.quixada.samuel.vaporqx.service.ProductService;
import br.ufc.quixada.samuel.vaporqx.util.CustomFileUtils;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product saveProduct(Product product, MultipartFile image) {
		
		String imagePath = "images/" + product.getName() + ".png";
		CustomFileUtils.saveImage(imagePath, image);
		product.setImagePath(imagePath);
		
		return repository.save(product);
	}

	@Override
	public Product getProduct(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void removeProduct(Long id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}
	
}
