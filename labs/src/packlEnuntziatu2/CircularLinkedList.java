package packlEnuntziatu2;

import java.util.Iterator;

public class CircularLinkedList<T> implements ListADT<T>{
	protected Node<T> last;
	protected String deskr;
	protected int count;
	
	
	
	// eraikitzailea
	public CircularLinkedList(String pDeskr)
	{
		this.last = null;
		this.deskr = pDeskr;
		this.count = 0;
	}
	
	
	// metodoak
	
	public void setDeskr(String nom)
	{
		deskr=nom;
	}
	public String getDeskr()
	{
		return deskr;
	}
	public T removeFirst()
	{
		if(last==null) {
			return null;
		}
		Node<T> unekoa= last.next;
		last.next=unekoa.next;
		count--;
		return unekoa.elem;
	}
	public T removeLast() {
		Node<T> unekoa=last;
		if(unekoa==null) {
			return null;
		}
		while(unekoa.next!=last) {
			unekoa=unekoa.next;
		}
		last=unekoa;
		unekoa=unekoa.next;
		last.next=unekoa.next;
		count--;
		return unekoa.elem;
		
	}
	public T remove(T elem) {
		boolean aurk=false;
		Node<T> unekoa=last.next;
		Node<T> aurrekoa=null;
		if(unekoa==null) {
			return null;
		}
		while(!aurk&& aurrekoa!=last) {
			if(unekoa.elem.equals(elem)) {
				if(unekoa==last) {
					removeLast();
					aurk=true;
				}else {
					aurrekoa.next=unekoa.next;
					aurk=true;
				}
			} else {
				aurrekoa=unekoa;
				unekoa=unekoa.next;
			}
		}
		if(!aurk) {
			return null;
		}else {
			count--;
			return unekoa.elem;
		}
	}
	public T first() {
		Node<T> unekoa=last;
		if(unekoa==null) {
			return null;
		}
		return unekoa.next.elem;
	}
	public T last() {
		if(last==null) {
			return null;
		}
		return last.elem;
	}
	public boolean contains(T elem) {
		boolean aurk=false;
		Node<T> unekoa=last;
		while(unekoa.next!=last && !aurk) {
			if(unekoa.elem.equals(elem)) {
				aurk=true;
			}else {
				unekoa=unekoa.next;
			}
		}
		return aurk;
	}
	public T find(T elem) {
		if(contains(elem)) {
			return elem;
		}else {
			return null;
		}
	}
	public boolean isEmpty() {
		return(last==null);
	}
	public int size() {
		return count;
	}
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>{
		private Node<T> aux=last;
		private boolean lehena=false;
		public boolean hasNext() {
			if(isEmpty()) {
				return false;
			}
			else if (aux.equals(last) && lehena ){
				return false;
			}
			else {
				lehena=true;
				return true;
			}
		}

		public T next() {
			return aux.elem;
		}
		
	}
	public Node<T> getLast(){
		return last;
	}

}
