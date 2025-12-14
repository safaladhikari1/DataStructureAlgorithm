package structure;

import abstractDataType.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

	private static class ListNode<T> {
		private T data;
		private ListNode<T> next;

		public ListNode(T data) {
			this(data, null);
		}

		public ListNode(T data, ListNode<T> next) {
			this.data = data;
			this.next = next;
		}

		public ListNode() {
			this(null, null);
		}
	}

	private ListNode<T> head;
	private int size;

	public LinkedList() {
		head = null;
	}

	public void add(T value) {

		if(head == null) {
			head = new ListNode<T>(value);
		} else {
			ListNode<T> current = head;

			while(current.next != null) {
				current = current.next;
			}

			current.next = new ListNode<T>(value);
		}
		size++;
	}

	public void add(int index, T value) {

		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

		if(index == 0) {
			head = new ListNode<T>(value, head);
		} else {
			ListNode<T> current = head;

			for(int i=0; i < index - 1; i++) {
				current = current.next;
			}

			current.next = new ListNode<T>(value, current.next);

		}
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		head = null;
        size = 0;
	}

	// https://github.com/safaladhikari1/Java-Concepts2/blob/0b6e793d4f915fb566fb2af9764c52f49f712424/LinkedListPractice/src/linked_lists/LinkedList.java#L81
	public void remove(T value) {
		if(head == null) {
			return;
		}

		if(head.data.equals(value)) {
			head = head.next;
			size--;
			return;
		}

		ListNode<T> current = head;

		while(current.next != null && !current.next.data.equals(value)) {
			current = current.next;
		}

		if(current.next == null) {
			return;
		} else {
			current.next = current.next.next;
			size--;

			return;
		}
	}

	@Override
	public String toString() {
		if(head == null) {
			return "[]";
		} else {
			String result = "[" + head.data;
			ListNode<T> current = head;

			while(current.next != null) {
				current = current.next;
				result += ", " + current.data;
			}

			result += "]";

			return result;
		}
	}

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ListNode<T> current;

        public LinkedListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            T result = current.data;
            current = current.next;

            return result;
        }

    }

}
