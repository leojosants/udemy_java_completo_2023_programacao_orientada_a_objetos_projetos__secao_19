/*-------------------- packages section --------------------*/
package services;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.List;

/*-------------------- class PrintService<T> --------------------*/
public class PrintService<T> {
	
	/*-------------------- attributes section --------------------*/
	private List<T> integers_list = new ArrayList<>();

	/*-------------------- constructors section --------------------*/
	public PrintService() {
	}

	/*-------------------- methods section --------------------*/
	public void addVaule(T value) {
		integers_list.add(value);
	}

	public T first() {
		if (integers_list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return integers_list.get(0);
	}

	public void print() {
		System.out.print("Reported values .......: [");

		if (!integers_list.isEmpty()) {
			System.out.print(integers_list.get(0));
		}

		for (int i = 1; i < integers_list.size(); i++) {
			System.out.print(", " + integers_list.get(i));
		}

		System.out.print("]\n");
	}
}
