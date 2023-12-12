/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- class Product --------------------*/
public class Product implements Comparable<Product> {

	/*-------------------- attributes section --------------------*/
	private String name;
	private Double price;

	/*-------------------- constructors section --------------------*/
	public Product(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	/*-------------------- getters and setters section --------------------*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/*-------------------- methods section --------------------*/
	@Override
	public String toString() {
		return String.format("%s, R$ %.2f%n", this.getName(), this.getPrice());
	}

	@Override
	public int compareTo(Product other) {
		return this.getPrice().compareTo(other.getPrice());
	}

	public void printProduct() {
		System.out.println(toString());
	}
}
