/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.HashSet;
import java.util.Set;
import model.entities.Product;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	
	private static Set<Product> generateInstanceSetHashSet() {
		return new HashSet<>();
	}
	
	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}
	
	private static String generateInstanceString(String value) {
		return new String(value);
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}

	private static void runProgram() {
		Set<Product> set = generateInstanceSetHashSet();
		set.add(generateInstanceProduct(generateInstanceString("TV"), 900.0));
		set.add(generateInstanceProduct(generateInstanceString("Notebook"), 1200.0));
		set.add(generateInstanceProduct(generateInstanceString("Tablet"), 400.0));
		
		Product product = generateInstanceProduct(generateInstanceString("Notebook"), 1200.0);
		
		System.out.printf("\nObjeto '%s' contem no conjunto ..? %b%n", product, set.contains(product));
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {		
		runProgram();
		displayMessageEndOfProgram();
	}
}