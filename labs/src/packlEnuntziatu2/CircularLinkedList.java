package packlEnuntziatu2;

import java.util.Iterator;

public class CircularLinkedList<T> implements ListADT<T>{
	public Node<T> last;
	public String deskr;
	public int count;
	
	
	
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
		Node<T> unekoa= last.next;
		last.next=unekoa.next;
		return unekoa.elem;
	}
	public T removeLast() {
		Node<T> unekoa=last;
		while(!unekoa.next.equals(last)) {
			unekoa=unekoa.next;
		}
		last=unekoa;
		unekoa=unekoa.next;
		last.next=unekoa.next;
		return unekoa.elem;
		
	}
	public T remove(T elem) {
		boolean aurk=false;
		Node<T> unekoa=last;
		Node<T> aurrekoa=null;
		if(unekoa==null) {
			return null;
		}
		while(!aurk&& aurrekoa==last) {
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
		}
		return unekoa.elem;
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
		boolean pasata=false;
		int ema=0;
		Node<T> unekoa=last;
		if(last==null) {
			return ema;
		}
		while(!pasata) {
			ema++;
			unekoa=unekoa.next;
			if(unekoa==last) {
				pasata=true;
			}
		}
		return ema;
	}
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>{
		Node<T> aux=last;
		public boolean hasNext() {
			if(aux==null) {
				return false;
			}else {
				return true;
			}
		}

		public T next() {
			if(!hasNext()) {
				return null;
			}else {
				T ema=aux.elem;
				aux=aux.next;
				return ema;
			}
		}
		
	}
	

}
