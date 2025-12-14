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

    @Override
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

    @Override
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

    @Override
	public boolean isEmpty() {
		return size == 0;
	}

    @Override
	public int size() {
		return size;
	}

    @Override
	public void clear() {
		head = null;
        size = 0;
	}

	// https://github.com/safaladhikari1/Java-Concepts2/blob/0b6e793d4f915fb566fb2af9764c52f49f712424/LinkedListPractice/src/linked_lists/LinkedList.java#L81
	@Override
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
            throw new NoSuchElementException(value + " does not exist in the list.");
		} else {
			current.next = current.next.next;
			size--;
		}
	}

    @Override
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bound.");
        }

        ListNode<T> current = head;

        for(int i=0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public void addAll(List<T> other) {
        for(T value: other) {
            add(value);
        }
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        ListNode<T> current = head;
        while(current != null) {
            if(current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public void set(int index, T value) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }

        ListNode<T> current = head;
        for(int i=0; i < index; i++) {
            current = current.next;
        }

        current.data = value;
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
