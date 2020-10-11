package packlEnuntziatu1;

import java.util.ArrayList;
import java.util.Iterator;

public class Hitza {
	// atributuak
	private String katea;
	private ArrayList<Web> wLista;
	
	// eraikitzailea
	public Hitza (String pKatea){
		this.katea = pKatea;
		this.wLista = new ArrayList<Web>();
	}
	
	// getters	
	public ArrayList<Web> getWebLista(){
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
		this.wLista.add(pWeb);
	}
	
	public void beteWebLista (String pKatea){
		this.wLista = WebZerrenda.getNireWebZerrenda().word2Webs(pKatea);
	}
	
	public void gakoWebInprimatu() {
		System.out.println(" ");
		Iterator<Web> itr= this.getIteradorea();
		Web w=null;
		while(itr.hasNext()) {
			w=itr.next();
			System.out.println( w.getId() +" "+ w.getUrlWeb());						
		}
	}
}
