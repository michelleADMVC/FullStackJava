package com.example.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany 
	@JoinTable(
	name="categories_products",
	joinColumns=@JoinColumn(name="category_id"),
	inverseJoinColumns = @JoinColumn(name="product_id")
	)
	private List<Product> products;
	
	public Category() {}
	public Category(String name) {
		this.name = name;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Long getId() {
		return id;
	}
    public String getName() {
		return name;
	}
    public List<Product> getProducts() {
		return products;
	}
}
