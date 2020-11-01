package packlEnuntziatu2;
import packlEnuntziatu1.Web;
import java.util.Iterator;

public class Hitza {
	// atributuak
	private String katea;
	private UnorderedCircularLinkedList<Web> wLista;
	
	// eraikitzailea
	public Hitza (String pKatea){
		this.katea = pKatea;
		this.wLista = new UnorderedCircularLinkedList<Web>("Weben lista");
	}
	
	// getters	
	public UnorderedCircularLinkedList<Web> getWebLista(){
		return this.wLista;
	}
	
	public String getKatea(){
		return this.katea;
	}
	
	// metodoak
	private Iterator<Web> getIteradorea(){
		return this.wLista.iterator();
	}


	public void gehituWebBat(Web pWeb){
		this.wLista.addToRear(pWeb);
	}

	public void gakoWebInprimatu() {
		System.out.println(" ");
		Iterator<Web> itr= this.getIteradorea();
		Web w=null;
		while(itr.hasNext()) {
			w=itr.next();
			w.webInprimatu();
		}
	}
}
