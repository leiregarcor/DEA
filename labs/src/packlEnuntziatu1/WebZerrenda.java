package packlEnuntziatu1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class WebZerrenda {
	
	// atributuak
	private static WebZerrenda nireWebZerrenda = null;
	private ArrayList<Web>wZerrenda;
	//HashMap sortu behar dugu non Key = url eta Value = Web objektua
	private ArrayList<String>urlZerrenda;
	
	// eraikitzailea
	private WebZerrenda() {
		this.wZerrenda = new ArrayList<Web>();
		this.urlZerrenda= new ArrayList<String>();
	}
	
	// gainontzeko metodoak
	
	private Iterator<Web> getIteradorea()
	{
		return this.wZerrenda.iterator();
	}
	public static WebZerrenda getNireWebZerrenda() {
		if(nireWebZerrenda == null){
			nireWebZerrenda = new WebZerrenda();
		}
		return nireWebZerrenda;
	} 
	
	public void fitxeroaKargatu(File pIndexFitxeroa) throws FileNotFoundException {
		//Metodo hau jasotzen du: Fitxeroa web orrien url-ekin eta indizeekin.
		//Metodo hau sartzen du informazio hori web objektuetan eta gero webzerrendan
		
		FileReader fr = new FileReader (pIndexFitxeroa);
        BufferedReader b = new BufferedReader(fr);
        
        String lerro;
    	WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
    	
		try {
	        while ((lerro = b.readLine())!=null)
	        {
	        	
	        	//TODO
	        	// Falta zaigu hash mapan ere sartzea
	        	String zatiak[] = lerro.split(" "); // Zatitzen dugu web url eta indizea
	        	// Sortzen dugu Web objektu bat eta sartzen dugu indizea eta url parametro bezala
	        	Web w = new Web(Integer.parseInt(zatiak[1]), zatiak[0]);
	        	// azkenik, gehitzen dugu web zerrendara
	        	wz.gehitu(w);       	
	        }
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{ // Finally hay da fitxeroa ixteko zerbait txarto badoa.
	        try{                    
		           if( null != fr ){   
		              fr.close();     
		           }                  
		        }catch (Exception e2){ 
		           e2.printStackTrace();
		        }
		     }
		
	}
	
	
	public void fitxeroaEguneratu() {}
	
	public Web bilatuUrl(String pUrl) {
		Web ema=null;
		Iterator<Web>itr= this.getIteradorea();
		boolean aurkitua=false;
		while(itr.hasNext()&&!aurkitua) {
			ema=itr.next();
			if(ema.estekaBerdinaDu(pUrl)) {
				aurkitua=true;
			}
		}
		return ema;
	}
	
	public Web bilatuId(int pId) {
		Web ema=null;
		Iterator<Web>itr= this.getIteradorea();
		boolean aurkitua=false;
		while(itr.hasNext()&&!aurkitua) {
			ema=itr.next();
			if(ema.idBerdinaDu(pId)) {
				aurkitua=true;
			}
		}
		return ema;
	} 
	
	public void gehitu (Web pWeb) 
	{
		this.wZerrenda.add(pWeb);
		urlZerrenda.add(pWeb.getUrlWeb());
	}
	
	public void ezabatu (String pUrl) 	{
		Web w=bilatuUrl(pUrl);
		if(w!=null) {
		urlZerrenda.remove(pUrl);
		this.wZerrenda.remove(w);
		
		}
	}
	
	public void webOrdenatuta(ArrayList<String> pZerrenda){
		// post: web-orrien zerrenda itzultzen du, alfabetikoki ordenatuta
		//TODO
		
	}
	
	public String id2String(int pId) {
		// Postbaldintza: osoko bat emanda, dagokion web-orria itzuliko du
		String ema = "";
		Web w=bilatuId(pId);
		if(w!=null) {
		ema=w.getUrlWeb();
		}
		return ema;
	}
	
	public int string2Id(String pUrl) {
		// Url bat sartu eta bere indizea bueltatzen du
		int ema = -1;
		Web w=bilatuUrl(pUrl);
		if(w!=null) {
		ema=w.getId();
		}
		return ema;
	}
	
	public ArrayList<Web> irteerakoEstekak(String pUrl)	{
		// post: web-orri baten izena emanda, estekatzen dituen web-orriak itzultzen ditu.
		Web w=bilatuUrl(pUrl);
		ArrayList<Web>a=new ArrayList<Web>();
		if(w!=null) {
		a=w.getEstekenZerrenda();
		}
		return a;
	}
	
	public ArrayList<Web> word2Webs(String pGako){
		// pre: parametroa gako-hitz bat da
		// post:  gako-hitza daukaten web-orriak itzultzen ditu
		ArrayList<Web> ema = new ArrayList<Web>();
		return ema;
	}
	
	public ArrayList<Hitza> web2Words(String pUrl){
		// post: web-orrian agertzen diren gako-hitzak itzultzen ditu
		ArrayList<Hitza> ema = new ArrayList<Hitza>();
		return ema;
	}
	
	
	

}
