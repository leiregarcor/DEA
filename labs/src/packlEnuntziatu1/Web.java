package packlEnuntziatu1;

import java.util.*;

public class Web {
	// atributuak
	private int id;
	private ArrayList<Web>estekenZerrenda; // Hemen gordeko dira web bakoitzak dituen esteken id-ak
	private ArrayList<String>gakoZerrenda;
	private String url;
	
	// eraikitzailea
	public Web (int pId, String pUrl) {
		this.id= pId;
		this.url =  pUrl;
		this.estekenZerrenda= new ArrayList<Web>() ;
		this.gakoZerrenda= new ArrayList<String>();
	}
	
	
	// getters
	
	public String getUrlWeb()
	{
		return this.url;
	}
	
	// gainontzeko metodoak

	public boolean estekaBerdinaDu (String pUrl) {
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
	}
	public int getId() {
		return this.id;
	}
	
	
	private void gehituGakoa(String pGakoa)
	{
		this.gakoZerrenda.add(pGakoa);
	}
	
	
	public void lortuGakoHitzak(Web pWeb) {}
	
	
	
	public ArrayList<String> getGakoZerrenda(){
		return this.gakoZerrenda;
	}
	
	public ArrayList<Web> getEstekenZerrenda(){
		return this.estekenZerrenda;
	}
	
}
