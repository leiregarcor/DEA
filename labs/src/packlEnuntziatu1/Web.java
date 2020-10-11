package packlEnuntziatu1;

import java.util.*;

public class Web {
	// atributuak
	private int id;
	private ArrayList<Web>estekenZerrenda; // Hemen gordeko dira web bakoitzak dituen esteken web-ak
	private ArrayList<Hitza>gakoZerrenda;   // Hemen gordeko dira web bakoitzak URL-AN DITUEN GAKOAK  
	private String url;
	
	// eraikitzailea
	public Web (int pId, String pUrl) {
		this.id= pId;
		this.url =  pUrl;
		this.estekenZerrenda= new ArrayList<Web>() ;
		this.gakoZerrenda= new ArrayList<Hitza>();
	}

	// getters
	public String getUrlWeb(){
		return this.url;
	}
	
	public int getId() {				
		return this.id;
	}
	
	// gainontzeko metodoak	
	private Iterator<Web> getIteradorea(){
		return this.estekenZerrenda.iterator();
	}

	public ArrayList<Hitza> getGakoZerrenda(){      
		return this.gakoZerrenda;
	}
	
	public ArrayList<Web> getEstekenZerrenda(){ 
		return this.estekenZerrenda;
	}
	
	public void webInprimatu() {
		System.out.println(" ");
		System.out.println("	Sartu duzun web orrialdearen informazioa honako da:");
		System.out.println(" url:     "+this.url);
		System.out.println(" indizea: "+this.id);
		System.out.println(" ");
	}
	
	public void estekaZerendaInprimatu() {
		System.out.println(" ");
		Iterator<Web> itr= this.getIteradorea();
		Web w=null;
		while(itr.hasNext()) {
			w=itr.next();
			System.out.println( w.id +" "+ w.url);						
		}
	}	
}
