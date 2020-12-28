package com.Product;

public class Product {

	private int id;
	private String name;
	private String category;
	private float price;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String category, float price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String department) {
		this.category = department;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
	
	
}