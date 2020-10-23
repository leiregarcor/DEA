package packlEnuntziatu2;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {

	public UnorderedCircularLinkedList(String pDeskr)
	{
		super(pDeskr);
		
	}

	public void addToFront(T elem) {
		Node<T> berria= new Node<T>(elem);
		if(isEmpty()) {
			last=berria;
			berria.next=berria;
		}else {
			berria.next=last.next;
			last.next=berria;
		}
	}

	public void addToRear(T elem) {
		Node<T> berria= new Node<T>(elem);
		berria.next=last.next;
		last.next=berria;
		last=berria;
	}

	public void addAfter(T elem, T target) {
		Node<T> berria= new Node<T>(elem);
		Node<T> unekoa= last;
		while(unekoa.next!=last) {
			if(unekoa.elem.equals(target)) {
				if(unekoa==last) {
					addToRear(elem);
				}else {
					berria.next=unekoa.next;
					unekoa.next=berria;
				}
				
			}
		}
		if(last.elem.equals(target)) {
			addToRear(elem);
		}
		
	}

}
