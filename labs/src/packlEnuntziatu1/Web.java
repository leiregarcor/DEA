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
	
	// gainontzeko metodoak
	

/*	public boolean estekaBerdinaDu (String pUrl) {
		boolean ema= false;
		if(this.url==pUrl) {
			ema=true;
		}
		return ema;
	}
	
	public boolean idBerdinaDu (int pId) {
		boolean ema=false;
		if(this.id==pId) {
			ema=true;
		}
		return ema;		
	}*/
	
	public int getId() {				// SE USA EN WebZerrenda.string2Id
		return this.id;
	}
		
	public ArrayList<Hitza> getGakoZerrenda(){      //SE USA EN WebZerrenda.word2Webs Y WebZerrenda.web2Words
		
		return this.gakoZerrenda;
	}
	
	public ArrayList<Web> getEstekenZerrenda(){ // SE USA EN WebZerrenda.irteerakoEstekak
		return this.estekenZerrenda;
	}
	
}
