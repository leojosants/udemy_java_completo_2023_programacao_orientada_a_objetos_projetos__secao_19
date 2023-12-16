/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- class Product --------------------*/
public class Product {
	
	/*-------------------- attributes section --------------------*/
	private String name;
	private Double price;

	/*-------------------- constructors section --------------------*/
	// default
	public Product() {
		//
	}

	// overload
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
		result = prime * result + ((this.getPrice() == null) ? 0 : this.getPrice().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		Product other = (Product) obj;
		
		if (this.getName() == null) {
			if (other.getName() != null) return false;
		} 
		else if (!this.getName().equals(other.getName())) return false;
		
		if (this.getPrice() == null) {
			if (other.getPrice() != null) return false;
		} 
		else if (!this.getPrice().equals(other.getPrice())) return false;

		return true;
	}
}
