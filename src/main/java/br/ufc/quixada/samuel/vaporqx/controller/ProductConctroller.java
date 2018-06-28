package br.ufc.quixada.samuel.vaporqx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.quixada.samuel.vaporqx.model.Product;
import br.ufc.quixada.samuel.vaporqx.service.impl.ProductServiceImpl;

/**
 * @author samue
 *
 */
@Controller
public class ProductConctroller {
	
	@Autowired
	private ProductServiceImpl service;

	@GetMapping("/")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("products", service.findAll());
		
		return mv;
	}
	
	@RequestMapping("/product/add")
	public ModelAndView add(Product product) {
		ModelAndView mv = new ModelAndView("productRegistration");
		mv.addObject("product", product);
		return mv;	
	}
	
	@PostMapping("/product/save")
	public String save(Product product,@RequestParam(value= "image") MultipartFile image, BindingResult result) {
		/*if(result.hasErrors()) {
			return add(product);
		}*/
		
		service.saveProduct(product, image);
		return "redirect:/";
	}
	
	@RequestMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable Long id) {
		service.removeProduct(id);
		
		return "redirect:/";
		
	}
	
}
