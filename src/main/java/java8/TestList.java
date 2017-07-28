package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			list.add(i + "");
		}

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}

		System.out.println(list.size());
	}

}
