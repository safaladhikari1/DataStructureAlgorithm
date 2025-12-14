package structure;

import abstractDataType.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

	private List<String> list;

	private List<String> createList() {
		//return new ArrayList<>();
        return new LinkedList<>();
	}

    @BeforeEach
	public void setup() {
		list = createList();
	}

	@Test
	public void testAdd() {
		String[] testList = {"a", "b", "c"};

		for(int i=0; i < testList.length; i++) {
			list.add(testList[i]);
		}

		for(int i=0; i < testList.length; i++) {
			assertEquals(true, list.contains(testList[i]), "Items added to the list is discoverable with contains()");
		}
	}

	@Test
	public void sizeTest() {
		String[] elementsToAdd = {"a", "b", "c"};

		for(int i=0; i < elementsToAdd.length; i++) {
			list.add(elementsToAdd[i]);
		}

		assertEquals(3, list.size(), "List should have size 3 after three calls to add()");
	}

	@Test
	public void getNegativeIndexTest() {
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertEquals("-1 is out of bound.", thrown.getMessage());
	}

	@Test
	public void removeTest() {
		String[] elementsToAdd = {"a", "b", "c"};

		for(int i=0; i < elementsToAdd.length; i++) {
			list.add(elementsToAdd[i]);
		}

		System.out.println(list.toString());

		for(int i=0; i < elementsToAdd.length; i++) {
			list.remove(elementsToAdd[i]);
		}

		assertEquals(0, list.size(), "List size should be 0 after removing all elements");
	}

	@Test
	public void getNoSuchElementremoveTest() {
		String[] elementsToAdd = {"a", "b", "c"};

		for(int i=0; i < elementsToAdd.length; i++) {
			list.add(elementsToAdd[i]);
		}

		String[] elementsToRemove = {"d", "e", "f"};
		for(int i=0; i < elementsToAdd.length; i++) {
			try {
				list.remove(elementsToRemove[i]);

				fail("No exception is thrown when removing an element that doesn't exist: " + elementsToRemove[i]);
			} catch (NoSuchElementException e) {

			}
		}
	}

	@Test
	public void hasNextIteratorTest() {
		Iterator<String> testIterator = list.iterator();
		assertEquals(false, testIterator.hasNext(), "Iterator should not report elements for a newly created list");
	}

	@Test
	public void nextIteratorTest() {
		String[] elementsToAdd = {"a", "b", "c"};

		for(int i=0; i < elementsToAdd.length; i++) {
			list.add(elementsToAdd[i]);
		}

		Iterator<String> testIterator = list.iterator();

		for(int i=0; i < elementsToAdd.length; i++) {
			assertEquals(elementsToAdd[i], testIterator.next(), "next() should return correct elements from the list");
		}

		assertEquals(false, testIterator.hasNext(), "hasNext() should return after reaching to the end of the list");
	}

}