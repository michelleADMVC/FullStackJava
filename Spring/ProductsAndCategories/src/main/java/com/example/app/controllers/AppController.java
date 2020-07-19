package com.example.app.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.models.Category;
import com.example.app.services.CategoryService;
import com.example.app.services.ProductService;

@Controller
public class AppController {
	private CategoryService categoryService;
	private ProductService productService;
	
	public AppController(CategoryService inject1, ProductService inject2){
		categoryService = inject1;
		productService = inject2;
	}
	@RequestMapping(value = "/products/{id}", method =  RequestMethod.GET)
	public String getNewProduct(Model model, @PathVariable("id")Long id) {
		model.addAttribute("product", productService.getProduct(id));
		model.addAttribute("availableCategories",productService.matchCategories(categoryService.getAll(), id));
		return "product.html";
	}
	@RequestMapping(value = "/categories/{id}", method =  RequestMethod.GET)
	public String getNewCategories(Model model, @PathVariable("id")Long id) {
		model.addAttribute("category", categoryService.getCategory(id));
		model.addAttribute("availableProducts",productService.getAll());
		return "category.html";
	}
	
	@RequestMapping(value = "/category/add", method =  RequestMethod.POST)
	public String addCategoryToProduct(
			@RequestParam("category_id")Long catId, 
			@RequestParam("product_id")Long proId) {
		productService.addCategory(proId,categoryService.getCategory(catId));
		return "redirect:/products/"+proId;
	}
	@RequestMapping(value = "/product/add", method =  RequestMethod.POST)
	public String addProductToCategory(
			@RequestParam("category_id")Long catId, 
			@RequestParam("product_id")Long proId) {
		productService.addCategory(proId,categoryService.getCategory(catId));
		
		return "redirect:/categories/"+catId;
	}
	
	@RequestMapping(value = "/products/new", method =  RequestMethod.GET)
	public String getNewProduct() {
		return "newProduct.html";
	}
	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String postNewProduct(
			@RequestParam("name")String name,
			@RequestParam("description")String description,
			@RequestParam("price")double price){
		this.productService.newProduct(name, description, price);
		return "redirect:/products/new";
	}
	@RequestMapping(value = "/categories/new", method =  RequestMethod.GET)
	public String getNewCategory() {
		return "newCategory.html";
	}
	@RequestMapping(value = "/categories/new", method =  RequestMethod.POST)
	public String postNewCategory(@RequestParam("name") String name) {
		categoryService.newCategory(name);
		return "redirect:/categories/new";
	}
}
