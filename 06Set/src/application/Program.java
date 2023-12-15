package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	private static Set<String> generateInstanceSetHashSet() {
		return new HashSet<>();
	}

	private static Set<String> generateInstanceSetTreeSet() {
		return new TreeSet<>();
	}

	private static Set<String> generateInstanceSetLinkedHashSet() {
		return new LinkedHashSet<>();
	}

	private static String generateInstanceString(String value) {
		return new String(value);
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n---------- fim do programa ----------");
	}

	private static void displaySetItems(Set<String> set) {
		System.out.println("\nExibindo conjunto de elementos");
		for (String item : set) {
			System.out.printf(" %s%n", item);
		}
	}
	
	private static void example01() {
		// implementacao HashSet - mais rápido (operações O(1) em tabela hash) e não ordenado
		Set<String> set_hashSet = generateInstanceSetHashSet();
		
		// implementacao TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
		Set<String> set_treeSet = generateInstanceSetTreeSet();
		
		// implementacao LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados
		Set<String> set = generateInstanceSetLinkedHashSet();		
		
		System.out.println("\nAdicionado itens");
		System.out.printf("1º ..: Tv %n", set.add(generateInstanceString("Tv")));
		System.out.printf("2º ..: Tablet %n", set.add(generateInstanceString("Tablet")));
		System.out.printf("3º ..: Notebook %n", set.add(generateInstanceString("Notebook")));
		
		String search_item = generateInstanceString("Notebook");
		String removed_item = generateInstanceString("Tablet");
		
		System.out.println();
//		System.out.printf("Item existe no conjunto .......................................? [%s] %b%n", search_item, set.contains("Notebook"));
//		System.out.printf("Item foi removido do conjunto .................................? [%s] %b%n", removed_item, set.remove(removed_item));
		System.out.printf("Item(s) que iniciam com 'T' foi removido do conjunto ..........? %b%n", set.removeIf(x -> x.charAt(0) == 'T'));
//		System.out.printf("Item(s) com pelo menos 3 caracteres foi removido do conjunto ..? %b%n", set.removeIf(x -> x.length() >= 3));
		displaySetItems(set);		
	}
	
	private static void example02() {
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));
		
		System.out.println("Conjunto A ......................: " + a);
		System.out.println("Conjunto B ......................: " + b);
		
		// union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println("Conjunto C -> Uniao      A e B ..: " + c);
		
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println("Conjunto D -> Intersecao D e A ..: " + d);
		
		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println("Conjunto E -> Diferenca  E e A ..: " + e);
	}

	private static void runProgram() {
//		example01();
		example02();
	}

	public static void main(String[] args) {
		runProgram();
		displayMessageEndOfProgram();
	}
}