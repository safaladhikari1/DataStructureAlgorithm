import abstractDataType.List;
import structure.ArrayList;
import structure.LinkedList;

import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
		List<String> testList = new LinkedList<>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		System.out.println("Before change: ");
		System.out.println(testList.toString());

		System.out.println("After Add: ");
		testList.add(1, "d");
		System.out.println(testList.toString());

		System.out.println("After Remove: ");
		testList.remove("a");
		System.out.println(testList.toString());

		System.out.println("Is Empty: ");
		System.out.println(testList.isEmpty());
		System.out.println(testList.size());

		System.out.println("Testing addAll(): ");
		List<String> testList2 = new LinkedList<>();
		testList2.addAll(testList);
		System.out.println(testList2.toString());

		System.out.println("Testing Iterator: ");
		Iterator<String> testList2Iterator = testList2.iterator();

		while(testList2Iterator.hasNext()) {
			System.out.println(testList2Iterator.next());
		}

        System.out.println("Testing indexOf(): " + testList2.indexOf("b"));

        System.out.println("Testing set()");
        testList2.set(0, "a");
        System.out.println(testList2.toString());
    }
}
