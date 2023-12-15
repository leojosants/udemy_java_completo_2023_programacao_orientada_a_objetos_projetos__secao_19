/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.Set;
import java.util.TreeSet;
import model.entities.Product;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	
	private static Set<Product> generateInstanceSetTreeSet() {
		return new TreeSet<>();
	}
	
	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}
	
	private static String generateInstanceString(String value) {
		return new String(value);
	}
	
	private static void dislayData(Set<Product> set) {
		for (Product product : set) {
			product.printProduct();			
		}
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}

	private static void runProgram() {
		// TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
		Set<Product> set = generateInstanceSetTreeSet();
		
		set.add(generateInstanceProduct(generateInstanceString("TV"), 900.0));
		set.add(generateInstanceProduct(generateInstanceString("Notebook"), 1200.0));
		set.add(generateInstanceProduct(generateInstanceString("Tablet"), 400.0));
		
		dislayData(set);
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {		
		runProgram();
		displayMessageEndOfProgram();
	}
}