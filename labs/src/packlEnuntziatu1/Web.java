package packlEnuntziatu1;

import java.util.*;

public class Web {
	// atributuak
	private int id;
	private ArrayList<Integer>estekenIdZerrenda; // Hemen gordeko dira web bakoitzak dituen esteken id-ak
	private ArrayList<String>gakoZerrenda;
	private String url;
	
	// eraikitzailea
	public Web (int pId, String pUrl) {
		this.id= pId;
		this.url =  pUrl;
		this.estekenIdZerrenda= new ArrayList<Integer>() ;
		this.gakoZerrenda= new ArrayList<String>();
	}
	
	
	// getters
	
	public String getUrlWeb()
	{
		return this.url;
	}
	
	// gainontzeko metodoak

	public boolean EstekaBerdinaDu (String pUrl) {
		boolean ema= false;
		if(this.url==pUrl) {
			ema=true;
		}
		return ema;
	}
	
	public boolean IdBerdinaDu (int pId) {
		boolean ema=false;
		if(this.id==pId) {
			ema=true;
		}
		return ema;
	}
	public int getId() {
		return this.id;
	}
	
	
	private void gehituGakoa(String pGakoa)
	{
		this.gakoZerrenda.add(pGakoa);
	}
	
	
	public void LortuGakoHitzak(Web pWeb) {}
	
	
	
	public ArrayList<String> getGakoZerrenda(){
		return this.gakoZerrenda;
	}
	
	
	
}
