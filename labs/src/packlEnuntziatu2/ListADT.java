package packlEnuntziatu2;

import java.util.Iterator;

public interface ListADT<T> {
	public void setDeskr(String nom);
	public String getDeskr();
	public T removeFirst();
	public T removeLast();
	public T remove(T elem);
	public T first();
	public T last();
	public boolean contains(T elem);
	public T find(T elem);
	public boolean isEmpty();
	public int size();
	public Iterator<T> iterator();
}
