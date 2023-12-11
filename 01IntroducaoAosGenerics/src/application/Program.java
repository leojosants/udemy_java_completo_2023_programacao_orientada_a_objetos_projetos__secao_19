/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.Scanner;
import services.PrintService;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static PrintService<String> generateInstancePrintService() {
		return new PrintService<>();
	}
	
	private static int requestTotalValues(Scanner scanner) {
		System.out.print("\nHow many values? ");
		int total_value = scanner.nextInt();
		scanner.nextLine(); // buffer
		return total_value;
	}
	
	private static String requestValues(int i, Scanner scanner) {
		String value = null;
		System.out.printf("Enter the %dº value ..: ", i);
		value = scanner.nextLine().trim();
		
		while (value.isEmpty()) {
			System.out.printf("-> Invalid data, try again! Enter the %dº value ..: ", i);
			value = scanner.nextLine().trim();
		}
		
		return value;
	}
	
	private static void fillList(PrintService<String> print_service, String temporary_value ) {
		print_service.addVaule(temporary_value);
	}
	
	private static void requestData(int total_value, Scanner scanner, PrintService<String> print_service) {
		for (int i = 1; i <= total_value; i++) {
			String temporary_value = requestValues(i, scanner);
			fillList(print_service, temporary_value);
		}
	}
	
	private static void displayData(PrintService<String> print_service, String first_value ) {
		System.out.println("\n----- Displaying data -----");
		print_service.print();
		System.out.printf("First value reported ..: %s%n", first_value);
	}
	
	private static void displayMessageIllegalStateException(Throwable e) {
		System.out.println(e.getMessage());
	}
	
	private static void displayMessageEndProgram() {
		System.out.println("\n----- end of program -----");
	}
	
	private static void runProgram() {
		Scanner scanner = generateInstanceScanner();
		PrintService<String> print_service = generateInstancePrintService() ;

		try {
			int total_value = requestTotalValues(scanner);
			requestData(total_value, scanner, print_service);
			String first_value = print_service.first();
			displayData(print_service, first_value);
		} 
		catch (IllegalStateException e) {
			displayMessageIllegalStateException(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			scanner.close();
			displayMessageEndProgram();
		}
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
