/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.ShapeInterface;
import model.entities.Circle;
import model.entities.Rectangle;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static List<ShapeInterface> generateInstanceListShapeInterface() {
		List<ShapeInterface> list_of_shapes = new ArrayList<>();
		return list_of_shapes;
	}

	private static Rectangle generateInstanceRectangle(Double width, Double height) {
		return new Rectangle(width, height);
	}

	private static Circle generateInstanceCircle(Double radius) {
		return new Circle(radius);
	}

	private static List<Circle> generateInstanceListCircle() {
		List<Circle> list_of_circles = new ArrayList<>();
		return list_of_circles;
	}

	private static List<Rectangle> generateInstanceListRectangle() {
		List<Rectangle> list_of_rectangles = new ArrayList<>();
		return list_of_rectangles;
	}

	private static List<Integer> generateInstanceListInteger() {
		List<Integer> list_of_integers = new ArrayList<>();
		return list_of_integers;
	}
	
	private static List<Object> generateInstanceListObject() {
		List<Object> list_of_objects = new ArrayList<>();
		return list_of_objects;
	}

	private static double totalArea(List<? extends ShapeInterface> list) {
		double sum = 0.0;
		for (ShapeInterface shape : list) {
			sum += shape.area();
		}
		return sum;
	}
	
	private static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}
	
	private static void printList(List<?> list) {
		for (Object object : list) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
	
	private static void displayAreas(List<ShapeInterface> list_of_shapes, List<Circle> list_of_circles, List<Rectangle> list_of_rectangle) {
		System.out.println("\nCalculo das areas");
		System.out.printf("Area total figuras ....: %.2fcm²%n", totalArea(list_of_shapes));
		System.out.printf("Area total circulo ....: %.2fcm²%n", totalArea(list_of_circles));
		System.out.printf("Area total retangulo ..: %.2fcm²%n", totalArea(list_of_rectangle));
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n----- fim do programa -----");
	}

	private static void example01() {
		List<ShapeInterface> list_of_shapes = generateInstanceListShapeInterface();
		list_of_shapes.add(generateInstanceRectangle(3.0, 2.0));
		list_of_shapes.add(generateInstanceCircle(2.0));

		List<Circle> list_of_circles = generateInstanceListCircle();
		list_of_circles.add(generateInstanceCircle(2.0));
		list_of_circles.add(generateInstanceCircle(3.0));

		List<Rectangle> list_of_rectangle = generateInstanceListRectangle();
		list_of_rectangle.add(generateInstanceRectangle(8.0, 3.0));
		list_of_rectangle.add(generateInstanceRectangle(4.0, 5.0));
		
		displayAreas(list_of_shapes, list_of_circles, list_of_rectangle);
	}

	private static void exampleGetPutPrinciple() {
		List<Integer> list_of_integers = Arrays.asList(1, 2, 3, 4);
		List<Double> list_of_doubles = Arrays.asList(3.14, 6.28);
		List<Object> list_of_objects = generateInstanceListObject();
		
		copy(list_of_integers, list_of_objects);
		printList(list_of_objects);
		
		copy(list_of_doubles, list_of_objects);
		printList(list_of_objects);
	}

	private static void exampleGetPutPrincipleCovariance() {
		List<Integer> list_of_integers = generateInstanceListInteger();
		list_of_integers.add(10);
		list_of_integers.add(5);

		List<? extends Number> list_of_numbers = list_of_integers;

		Number x = list_of_numbers.get(0);

//		list.add(20); // erro de compilacao
	}
	
	private static void exampleGetPutPrincipleContravariance() {
		List<Object> list_of_objects = generateInstanceListObject();
		list_of_objects.add("Ana");
		list_of_objects.add("Jose");

		List<? super Number> list_of_numbers = list_of_objects;
		list_of_numbers.add(10);
		list_of_numbers.add(10.5);

//		Number x = list_of_numbers.get(0); // erro de compilacao
	}

	private static void runProgram() {
		// Vamos fazer um método para retornar a soma das áreas de uma lista de figuras.
//		example01();

		// Vamos fazer um método que copia os elementos de uma lista para uma outra
		// lista que pode ser mais genérica que a primeira.
//		exampleGetPutPrinciple();

		// permite somente acessar e não adicionar
//		exampleGetPutPrincipleCovariance();

		// permite somente adicionar e não acessar
//		exampleGetPutPrincipleContravariance();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
		displayMessageEndOfProgram();
	}
}
