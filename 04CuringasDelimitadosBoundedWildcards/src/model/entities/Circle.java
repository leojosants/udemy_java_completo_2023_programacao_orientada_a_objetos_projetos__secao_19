/*-------------------- packages section --------------------*/
package model.entities;

/*-------------------- imports section --------------------*/
import model.ShapeInterface;

/*-------------------- class Rectangle --------------------*/
public class Circle implements ShapeInterface {

	/*-------------------- attributes section --------------------*/
	private Double radius;

	/*-------------------- constructors section --------------------*/
	public Circle() { // default
		//
	}

	// overload
	public Circle(Double radius) {
		this.setRadius(radius);
	}

	/*-------------------- getters and setters section --------------------*/
	public Double getRadius() {
		return this.radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	/*-------------------- class Rectangle --------------------*/
	@Override
	public double area() {
		return Math.PI * Math.pow(this.getRadius(), 2);
	}
}
