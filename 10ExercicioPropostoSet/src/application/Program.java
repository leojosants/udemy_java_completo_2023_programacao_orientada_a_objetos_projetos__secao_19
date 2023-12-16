/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static Set<Integer> generateInstanceHashSet() {
		return new HashSet<>();
	}

	private static int requestTotalStudents(Scanner scanner, Character course) {
		Integer total_students = null;
		
		System.out.printf("\nQuantos alunos para o curso '%s' ..: ", course.toString().toUpperCase());
		total_students = scanner.nextInt();
		scanner.nextLine(); // buffer
		
		if(total_students <= 0) {
			throw new IllegalStateException("campo não pode ser vazio");
		}
		
		return total_students;
	}
	
	private static void requestCode(int total_student, Scanner scanner, Set<Integer> course) {
		for (int i = 1; i <= total_student; i++) {
			System.out.printf(" Código do %dº aluno ..: ", i);
			int cod = scanner.nextInt();
			course.add(cod);
		}
	}
	
	private static void addStudentsToTheSet(Set<Integer> students_set, Set<Integer> course_a, Set<Integer> course_b, Set<Integer> course_c) {
		students_set.addAll(course_a);
		students_set.addAll(course_b);
		students_set.addAll(course_c);
	}
	
	private static void displayData(Set<Integer> students_set) {
		System.out.printf("\nTotal de alunos ..: %d%n", students_set.size());	}

	private static void displayMessageIllegalStateException(Throwable e) {
		System.out.printf("-> erro ..: %s%n", e.getMessage());
	}
	
	private static void displayMessageException(Throwable e) {
		System.out.printf("-> erro ..: %s%n", e);
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}
	
	private static void runProgram() {		
		Scanner scanner = generateInstanceScanner();

		try {
			Set<Integer> course_a = generateInstanceHashSet();
			Set<Integer> course_b = generateInstanceHashSet();
			Set<Integer> course_c = generateInstanceHashSet();
			Set<Integer> students_set = generateInstanceHashSet();
			
			Character course_name = null;
			
			course_name = 'A';
			int total_student_course_a = requestTotalStudents(scanner, course_name);
			requestCode(total_student_course_a, scanner, course_a);
			
			course_name = 'B';
			int total_student_course_b = requestTotalStudents(scanner, course_name);
			requestCode(total_student_course_b, scanner, course_b);

			course_name = 'C';
			int total_student_course_c = requestTotalStudents(scanner, course_name);
			requestCode(total_student_course_c, scanner, course_c);
			
			addStudentsToTheSet(students_set, course_a, course_b, course_c);
			displayData(students_set);
		}
		catch (IllegalStateException e) {
			displayMessageIllegalStateException(e);
		}
		catch (Exception e) {
			displayMessageException(e);
		}
		finally {
			scanner.close();
		}
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {		
		runProgram();		
		displayMessageEndOfProgram();
	}
}