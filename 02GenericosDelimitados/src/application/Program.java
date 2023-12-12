/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.entities.Product;
import services.CalculationService;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static List<Product> generateInstanceProductList() {
		return new ArrayList<>();
	}

	private static String generatePath() {
		return "c:\\temp\\in.txt";
	}

	private static FileReader generateInstanceFileReader(String path) throws FileNotFoundException {
		return new FileReader(path);
	}

	private static BufferedReader generateInstanceBufferedReader(FileReader file_path) {
		return new BufferedReader(file_path);
	}

	private static String performanceBufferedReader(BufferedReader buffered_reader) throws IOException {
		String line = buffered_reader.readLine();
		return line;
	}

	private static String[] lineSplit(String line) {
		return line.split(",");
	}

	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}

	private static double convertStringToDouble(String fields) {
		return Double.parseDouble(fields);
	}

	private static Product checkMostExpensive(List<Product> products_list) {
		return CalculationService.max(products_list);
	}

	private static void displayMostExpensive(Product most_expensive) {
		System.out.println("\nMost expensive ..: " + most_expensive);
	}

	private static void displayMessageFileNotFoundException(Throwable e) {
		System.out.println("-> error: " + e.getMessage());
	}

	private static void displayMessageIOException(Throwable e) {
		System.out.println("-> error: " + e.getMessage());
	}

	private static void displayMessageException(Throwable e) {
		System.out.println("-> error: " + e.getMessage());
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("-----> end of program <-----");
	}

	private static void runProgram() throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		List<Product> products_list = generateInstanceProductList();
		String path = generatePath();
		FileReader file_path = generateInstanceFileReader(path);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_path);

		try (buffered_reader) {
			String line = performanceBufferedReader(buffered_reader);

			while (line != null) {
				String[] fields = lineSplit(line);
				products_list.add(generateInstanceProduct(fields[0], convertStringToDouble(fields[1])));
				line = performanceBufferedReader(buffered_reader);
			}

			Product most_expensive = checkMostExpensive(products_list);
			displayMostExpensive(most_expensive);
		} 
		catch (FileNotFoundException e) {
			displayMessageFileNotFoundException(e);
		} 
		catch (IOException e) {
			displayMessageIOException(e);
		} 
		catch (Exception e) {
			displayMessageException(e);
		} 
		finally {
			displayMessageEndOfProgram();
		}
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) throws FileNotFoundException {
		runProgram();
	}
}
