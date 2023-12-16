/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*-------------------- class Program --------------------*/
public class Program {
	
	/*-------------------- functions section --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static String generateInstanceString(String value) {
		return new String(value);
	}
	
	private static String requestPath(Scanner scanner) {
			String path = generateInstanceString("");
			
			System.out.println();
			System.out.print("Entre com o caminho do arquivo [c:\\..\\nome_do_arquivo.extensao] ..: ");
			path = scanner.nextLine().trim();
			
			while (path.isEmpty()) {
				System.out.print("-> Entrada inválida, tente novamente! Entre como caminho do arquivo [c:\\..\\nome_do_arquivo.extensao] ..: ");
				path = scanner.nextLine().trim();
			}
			
			return path;
	}
	
	private static File generateInstanceFile(String path) {
		return new File(path);
	}
	
	private static FileReader generateInstanceFileReader(File file_name) throws FileNotFoundException {
		return new FileReader(file_name);
	}
	
	private static BufferedReader generateInstanceBufferedReader(FileReader file_reader) {
		return new BufferedReader(file_reader);
	}
	
	private static Map<String, Integer> generateInstanceLinkedHashMap() {
		return new LinkedHashMap<>();
	}
	
	private static String readLine(BufferedReader buffered_reader) throws IOException {
		return buffered_reader.readLine();
	}
	
	private static String[] splitLine(String line){
		String[] fields = line.split(generateInstanceString(","));
		return fields;
	}
	
	private static int convertStringToInt(String value) {
		return Integer.parseInt(value);
	}
	
	private static boolean checkIfContainsKey(Map<String, Integer> vote_list, String name) {
		return vote_list.containsKey(name);
	}
	
	private static void addKey(Map<String, Integer> vote_list, String name, int number_of_votes, int current_votes) {
		vote_list.put(name, (number_of_votes + current_votes));
	}
	
	private static void addKey(Map<String, Integer> vote_list, String name, int number_of_votes) {
		vote_list.put(name, number_of_votes);
	}
	
	private static void displayData(Map<String, Integer> vote_list) {
		System.out.println("\nRelação de votos");
		for (String key : vote_list.keySet()) {
			System.out.printf("%s\t : %s%n", key, vote_list.get(key));
		}
	}

	private static void displayMessageIOException(Throwable e) {
		System.out.printf("-> erro.. : %s%n", e.getMessage());
	}
	
	private static void displayMessageException(Throwable e) {
		System.out.printf("-> erro ..: %s%n", e);
	}

	private static void runProgram() throws FileNotFoundException {
		Scanner scanner = generateInstanceScanner();
		String path = requestPath(scanner);
		File file_path = generateInstanceFile(path);
		FileReader file_reader = generateInstanceFileReader(file_path);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_reader);
		Map<String, Integer> vote_list = generateInstanceLinkedHashMap();
		
		try (buffered_reader) {
			String line = readLine(buffered_reader); // leitura da primeira linha
			
			while (line != null) {
				String[] fields = splitLine(line);
				String name = fields[0];
				int number_of_votes = convertStringToInt(fields[1]);
				
				if(checkIfContainsKey(vote_list, name)) {
					int current_votes = vote_list.get(name);
					addKey(vote_list, name, number_of_votes, current_votes);
				}
				else {
					addKey(vote_list, name, number_of_votes);
				}
				
				line = readLine(buffered_reader); // leitura do restante das linhas
			}
			
			displayData(vote_list);
		} 
		catch (IOException e) {
			displayMessageIOException(e);
		}
		catch (Exception e) {
			displayMessageException(e);
		}
		finally {
			scanner.close();
		}
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		runProgram();
		displayMessageEndOfProgram();
	}
}
