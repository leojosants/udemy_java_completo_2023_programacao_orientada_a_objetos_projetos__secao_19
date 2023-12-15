/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import model.entities.LogEntry;

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
				System.out.print("Entrada inválida, tente novamente! Entre como caminho do arquivo [c:\\..\\nome_do_arquivo.extensao] ..: ");
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
	
	private static Set<LogEntry> generateInstanceHashSet() {
		return new HashSet<>();
	}
	
	private static String readLine(BufferedReader buffered_reader) throws IOException {
		return buffered_reader.readLine();
	}
	
	private static String[] splitLine(String line){
		String[] fields = line.split(generateInstanceString(" "));
		return fields;
	}
	
	private static Date convertStringToDate(String value) {
		return Date.from(Instant.parse(value));
	}
	
	private static LogEntry generateInstanceLogEntry(String username, Date moment) {
		return new LogEntry(username, moment);
	}
	
	private static void displayData(Set<LogEntry> log_Entries_set) {
		System.out.printf("Total de usuários ..: %d%n", log_Entries_set.size());
	}

	private static void displayMessageIOException(Throwable e) {
		System.out.printf("-> erro.. : %s%n", e.getMessage());
	}
	
	private static void displayMessageException(Throwable e) {
		System.out.printf("-> erro ..: %s%n", e);
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}
	
	private static void runProgram() throws FileNotFoundException {
		// obs: foi utilizado a interface Set para não permitir insercao duplicada e a implementacao HashSet por ser mais rapida
		
		Scanner scanner = generateInstanceScanner();
		String path = requestPath(scanner);
		File file_name = generateInstanceFile(path);
		FileReader file_reader = generateInstanceFileReader(file_name);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_reader);
		
		try (buffered_reader) {
			Set<LogEntry> log_Entries_set = generateInstanceHashSet();
			String line = readLine(buffered_reader); // ler linha do arquivo
			
			while(line != null) {
				String[] fields = splitLine(line);
				String username = fields[0];
				Date moment = convertStringToDate(fields[1]);
				log_Entries_set.add(generateInstanceLogEntry(username, moment));
				line = readLine(buffered_reader); // ler linha do arquivo
			}
			
			displayData(log_Entries_set);
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
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) throws FileNotFoundException {		
		runProgram();
		displayMessageEndOfProgram();
	}
}