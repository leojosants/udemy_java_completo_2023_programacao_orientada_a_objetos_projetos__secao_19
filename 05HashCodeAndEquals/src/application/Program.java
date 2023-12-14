/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import model.entities.Client;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static String generateInstanceString(String value) {
		return new String(value).trim();
	}
	private static void exampleEqualsMethod() {
		String name_1 = generateInstanceString("Joao");
		String name_2 = generateInstanceString("Ana");
		System.out.println(name_1.equals(name_2));
	}

	private static void exampleHashCodeMethod() {
		String name_1 = generateInstanceString("Joao");
		String name_2 = generateInstanceString("Ana");
		System.out.println(name_1.hashCode());
		System.out.println(name_2.hashCode());
	}
	
	private static Client generateInstanceClient(String name, String email) {
		return new Client(name, email);
	}
	
	private static void displayComparisonBetweenObjects(Client client_1, Client client_2) {
		System.out.printf("\nComparando objetos '%s' e '%s' %n", client_1.getName(), client_2.getName());
		System.out.printf(" Nome ...........................: %s%n", client_1.getName());
		System.out.printf(" E-mail .........................: %s%n", client_1.getEmail());
		System.out.printf(" HashCode .......................: %d%n%n", client_1.hashCode());
		System.out.printf(" Nome ...........................: %s%n", client_2.getName());
		System.out.printf(" E-mail .........................: %s%n", client_2.getEmail());
		System.out.printf(" HashCode .......................: %d%n%n", client_2.hashCode());
		System.out.printf(" client.equals(other_client) ....: %b%n", client_1.equals(client_2));
		System.out.printf(" client == other_client .........: %b%n%n", client_1 == client_2);
	}

	private static void exampleCustomHashCodeAndEquals() {
		Client client_1 = generateInstanceClient(generateInstanceString("Joao"), generateInstanceString("joao@joao.com"));
		Client client_2 = generateInstanceClient(generateInstanceString("Ana"), generateInstanceString("ana@ana.com"));
		displayComparisonBetweenObjects(client_1, client_2);
		
		Client client_3 = generateInstanceClient(generateInstanceString("Ana"), generateInstanceString("ana@ana.com"));
		Client client_4 = generateInstanceClient(generateInstanceString("Ana"), generateInstanceString("ana@ana.com"));
		displayComparisonBetweenObjects(client_3, client_4);
	}

	private static void runProgram() {
//		exampleEqualsMethod();
//		exampleHashCodeMethod();
		exampleCustomHashCodeAndEquals();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
