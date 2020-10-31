package packlEnuntziatu2;

public class OrderedCircularLinkedList<T> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	
	public OrderedCircularLinkedList(String pDeskr)
	{
		super(pDeskr);
		
	}

	public void add(T elem) {
		Node<T> unekoa= last.next;
		Node<T> aurrekoa= last;
		boolean txertatuta=false;
		Node<T> berria= new Node<T>(elem);
		while(aurrekoa!=last && !txertatuta) {
			if(elem.toString().compareTo(unekoa.elem.toString())<=0) {
				berria.next=unekoa;
				aurrekoa.next=berria;
				txertatuta=true;
			}else {
				aurrekoa=unekoa;
				unekoa=unekoa.next;
			}
		}
		if(!txertatuta) {
			berria.next=last.next;
			last.next=berria;
			last=berria;
		}	
	}

	public void merge(OrderedCircularLinkedList<T> z) {
		if(z.last==null) {
			
		}else {
			Node<T> l1= last.next;
			Node<T> l1aur= last;
			Node<T> l2= z.last.next;
			int s= this.size();
			int konp;
			while(this.size()!=s+z.size()){
				Node<T> berria= new Node<T>(l2.elem);
				konp= l2.elem.toString().compareTo(l1.elem.toString());
				if(konp<=0) {
					berria.next=l1;
					l1aur.next=berria;
					l2=l2.next;
					l1=berria;
				}else {
					if(l1==last) {
						berria.next=last.next;
						l1.next=berria;
						last=berria;
					}
					l1aur=l1;
					l1=l1.next;
				}
			}
		
		}
	}	
	
}
