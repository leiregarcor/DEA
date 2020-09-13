package packlEnuntziatu1;

import java.util.*;

public class Web {
	// atributuak
	private int id;
	private ArrayList<Integer>estekenIdZerrenda;
	private ArrayList<String>gakoZerrenda;
	private String url;
	
	// eraikitzailea
	public Web (int pId, String pUrl) {
		this.id= pId;
		this.url =  pUrl;
		this.estekenIdZerrenda= new ArrayList<Integer>() ;
		this.gakoZerrenda= new ArrayList<String>();
	}
	
	// gainontzeko metodoak

	public boolean EstekaBerdinaDu (String pUrl) {
		boolean ema= false;
		
		return ema;
	}
	
	
	private void gehituGakoa() {}
	
	
	public void LortuGakoHitzak() {}
	
	
	
	public ArrayList<String> getGakoZrrenda(){
		return this.gakoZerrenda;
	}
	
	
	
}
