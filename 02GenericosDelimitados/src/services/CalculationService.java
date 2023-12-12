/*------------------- packages section -------------------*/
package services;

/*------------------- imports section -------------------*/
import java.util.List;

/*------------------- class CalculationService -------------------*/
public class CalculationService {
	
	/*------------------- methods section -------------------*/
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		
		if(list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		
		T max = list.get(0);
		
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		
		return max;
	}
}
