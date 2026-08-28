package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product;

	private List<Product> products = new ArrayList<>();

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;

	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public Double subTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return product + ", " + price + ", Quantity:" + quantity + ", " + subTotal();
	}

}
