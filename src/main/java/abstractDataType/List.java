package abstractDataType;

public interface List<T> extends Iterable<T> {

	public int size();
//	public T get(int index);
//
//	public int indexOf(T value);
	public boolean isEmpty();
//	public boolean contains(T value);
	public void add(T value);

	public void add(int index, T value);
//	public void addAll(List<T> other);
	public void remove(T value);
//	public void set(int index, T value);
	public void clear();
}
