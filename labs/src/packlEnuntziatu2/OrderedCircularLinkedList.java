package packlEnuntziatu2;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	
	public OrderedCircularLinkedList(String pDeskr)
	{
		super(pDeskr);
		
	}

	public void add(T elem) {
		Comparable <T> generiko = (Comparable <T>) elem;
		boolean txertatuta=false;
		Node<T> berria= new Node<T>((T) generiko);
		if(last==null) {
			berria.next=berria;
			last=berria;
			count ++;
		}else {
			Node<T> unekoa= last.next;
			Node<T> aurrekoa= null;
			while(aurrekoa!=last && !txertatuta) {
				if(elem.compareTo((T) unekoa.elem)<=0) {
					if(unekoa==last.next) {
						last.next=berria;
						berria.next=unekoa;
					}else {
						berria.next=unekoa;
						aurrekoa.next=berria;
					}	
					txertatuta=true;
					count ++;
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
	}

	public void merge(OrderedCircularLinkedList<T> z) {
		if(z.last==null) {
			
		}else {
			if(last==null) {
				last=z.last;
			}else {
				Node<T> l1= last.next;
				Node<T> l1aur= last;
				Node<T> l2= z.last.next;
				int s= this.size();
				int konp;
				while(this.size()!=s+z.size()){
					Node<T> berria= new Node<T>(l2.elem);
					konp= l2.elem.compareTo((T) l1.elem);
					if(konp<=0) {
						berria.next=l1;
						l1aur.next=berria;
						l2=l2.next;
						l1=berria;
						count ++;
					}else {
						if(l1==last) {  		//lista amaitu da eta l2 l1 baino handiagoa da
							berria.next=last.next;
							l1.next=berria;
							last=berria;
							count ++;
						}
						l1aur=l1;
						l1=l1.next;
					}
				}
		
			}
		}
	}

}
