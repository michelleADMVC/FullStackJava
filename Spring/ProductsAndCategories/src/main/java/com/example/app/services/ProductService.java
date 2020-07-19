package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Category;
import com.example.app.models.Product;
import com.example.app.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepo;
	public ProductService(ProductRepository inject) {
		this.productRepo = inject;
	}
	public List<Product> getAll(){
		return this.productRepo.findAll();
	}
	public void saveProduct(Product product) {
		this.productRepo.save(product);
	}
	public void newProduct(String name,String description,double price) {
		this.productRepo.save(new Product(name,description,price));
	}
	public Product getProduct(Long id){
		Optional<Product> product = this.productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}
	public void addCategory(Long productId, Category category){
		 Product product = getProduct(productId);
		 product.addCategory(category);
		 this.saveProduct(product);
	}
	public List<Category> matchCategories(List<Category> categories, Long idProduct){
		List<Category> productCategories = this.getProduct(idProduct).getCategories();
		for (int i = 0; i < productCategories.size(); i++) {
			for (int j = 0; j < categories.size(); j++) {
				if (productCategories.get(i).getName().equals(categories.get(j).getName())) {
					categories.remove(j);
				}
			}
		}
		return categories;
	}
}
