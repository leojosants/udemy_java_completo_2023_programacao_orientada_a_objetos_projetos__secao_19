/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static void example01() {
		// List<Object> não é o supertipo de qualquer tipo de lista
		List<Object> objects_list_1 = new ArrayList<>();
		List<Integer> intergers_list_1 = new ArrayList<>();
//		objects_list = intergers_list; // Type mismatch: cannot convert from List<Integer> to List<Object>

		// O supertipo de qualquer tipo de lista é List<?>. Este é um tipo curinga
		List<?> objects_list_2 = new ArrayList<Object>();
		List<Integer> intergers_list_2 = new ArrayList<Integer>();
		objects_list_2 = intergers_list_2;
	}

	private static void printList(List<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	private static void example02() {
		List<Integer> integers_list = Arrays.asList(5, 2, 10);
		System.out.println("\nDisplaying list of integers");
		printList(integers_list);

		List<String> strings_list = Arrays.asList("João", "Lucas", "Mara");
		System.out.println("\nDisplaying list of strings");
		printList(strings_list);
	}

	private static void example03() {
		// não é possível adicionar dados a uma colecao do tipo curingo, pois o
		// compilador nao sabe especificar o tipo que se deseja adicionar
		List<?> list = new ArrayList<>();
//		list.add(5); // The method add(int, capture#3-of ?) in the type List<capture#3-of ?> is not applicable for the arguments (int)
	}

	private static void runProgram() {
//		example01();
//		example02();
//		example03();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
