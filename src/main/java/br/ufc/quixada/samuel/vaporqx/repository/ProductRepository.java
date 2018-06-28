package br.ufc.quixada.samuel.vaporqx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.quixada.samuel.vaporqx.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
