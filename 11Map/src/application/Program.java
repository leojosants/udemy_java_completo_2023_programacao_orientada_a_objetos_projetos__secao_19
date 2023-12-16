/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import model.entities.Product;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static Map<String, String> generateInstanceTreeMap() {
		return new TreeMap<>();
	}
	
	private static Map<Product, Double> generateInstanceHashMap() {
		return new HashMap<>();
	}
	
	private static String generateInstanceString(String value) {
		return new String(value);
	}
	
	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}
	
	private static void displayDataFromExample01(String pesquisar_chave_1, String pesquisar_chave_2, Map<String, String> records) {
		System.out.printf("Contém chave ..: [%s] %b%n", pesquisar_chave_1, records.containsKey(pesquisar_chave_1));
		System.out.printf("Valor  chave ..: [%s] %s%n", pesquisar_chave_1, records.get(pesquisar_chave_1));
		System.out.printf("Contém chave ..: [%s] %b%n", pesquisar_chave_2, records.containsKey(pesquisar_chave_2));
		System.out.printf("Valor  chave ..: [%s] %s%n", pesquisar_chave_2, records.get(pesquisar_chave_2));
		System.out.printf("Comprimento ...: %d%n", records.size());
	}
	
	private static void displayMapFromExample01(Map<String, String> records) {
		System.out.println("\nTodos os cookies");
		for (String key : records.keySet()) {
			System.out.printf("%s : %s%n", key, records.get(key));
		}
	}
	
	private static void displayDataFromExample02(Map<Product, Double> stock, Product product) {
		System.out.println("\nContém chave ..: " + product + " " + stock.containsKey(product));
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}
	
	private static void example01() {
		Map<String, String> records = generateInstanceTreeMap();
		records.put(generateInstanceString("usename"), generateInstanceString("usuario 1"));
		records.put(generateInstanceString("email"), generateInstanceString("usuario1@usuario.com"));
		records.put(generateInstanceString("telefone"), generateInstanceString("00000000000"));
		records.remove(generateInstanceString("email"));
		records.put(generateInstanceString("telefone"), generateInstanceString("00000000001"));
		
		String pesquisar_chave_1 = generateInstanceString("telefone");
		String pesquisar_chave_2 = generateInstanceString("email");
		
		displayDataFromExample01(pesquisar_chave_1, pesquisar_chave_2, records);
		displayMapFromExample01(records);
	}
	
	private static void example02() {
		Map<Product, Double> stock = generateInstanceHashMap();
		
		Product product_1 = generateInstanceProduct(generateInstanceString("Tv"), 900.0);
		Product product_2 = generateInstanceProduct(generateInstanceString("Notebook"), 1200.0);
		Product product_3 = generateInstanceProduct(generateInstanceString("Tablet"), 400.0);
		
		stock.put(product_1, 10000.0);
		stock.put(product_2, 20000.0);
		stock.put(product_3, 15000.0);
		
		Product product_4 = generateInstanceProduct(generateInstanceString("Tv"), 900.0);
		displayDataFromExample02(stock, product_4);
	}
	
	private static void runProgram() {		
//		example01();
		example02();
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {		
		runProgram();		
		displayMessageEndOfProgram();
	}
}