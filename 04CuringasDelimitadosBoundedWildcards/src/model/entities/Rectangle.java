/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- imports section --------------------*/
import model.ShapeInterface;

/*-------------------- class Rectangle --------------------*/
public class Rectangle implements ShapeInterface {

	/*-------------------- attributes section --------------------*/
	private Double width;
	private Double height;

	/*-------------------- constructors section --------------------*/
	public Rectangle() { // default
		//
	}

	// overload
	public Rectangle(Double width, Double height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	/*-------------------- getters and setters section --------------------*/
	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	/*-------------------- class Rectangle --------------------*/
	@Override
	public double area() {
		return this.getWidth() * this.getHeight();
	}
}
