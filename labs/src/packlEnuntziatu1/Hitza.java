package packlEnuntziatu1;

import java.util.ArrayList;

public class Hitza {
	// atributuak
	private String katea;
	private ArrayList<Web> wLista;
	
	// eraikitzailea
	public Hitza (String pKatea){
		this.katea = pKatea;
//		this.wLista = new ArrayList<Web>();
	}
	
	
	// getters	
	public ArrayList<Web> getWebLista(){
		return this.wLista;
	}
	
	
	public String getKatea(){
		return this.katea;
	}
	
	
	
	// metodoak
	
	public void beteWebLista (String pKatea){
		//TODO
		// Tiene que ir a WebZerrenda y recorrer el ArrayList (wZerrenda)
		// tiene que meter las Webs que tienen esa palabra en la url.
		
		this.wLista = WebZerrenda.getNireWebZerrenda().word2Webs(pKatea);
	}
	
	
/*	public boolean gakoBerdinaDa(String pGakoa) {                          //CREO QUE NO SE USA Y SE PUEDE BORRAR
		boolean ema= false;
		if(this.katea==pGakoa) {
			ema=true;
		}
		return ema;		
	}*/

}
