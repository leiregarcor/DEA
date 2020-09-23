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
	
	// eraikitzailea
	private WebZerrenda() {
		this.wZerrenda = new ArrayList<Web>();
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
	
	public Web bilatu(String pUrl) {
		Web ema=null;
		
		return ema;
	} 
	
	public void gehitu (Web pWeb) 
	{
		this.wZerrenda.add(pWeb);
	}
	
	public void ezabatu (String pUrl) 	{
		// sartutako url duen Web orria ezabatzen du
		Iterator<Web>itr = this.getIteradorea();
		boolean aurkituta = false;
		
		while ((itr.hasNext())&&(!aurkituta)) 
		{
			Web w = itr.next();
			if (w.getUrlWeb().contentEquals(pUrl))
			{
				this.wZerrenda.remove(w);
				aurkituta = true;
			}
		}
		
	}
	
	public void webOrdenatuta(ArrayList<Web> pZerrenda){
		// post: web-orrien zerrenda itzultzen du, alfabetikoki ordenatuta
		//TODO
	}
	
	public String id2String(int pId) {
		// Postbaldintza: osoko bat emanda, dagokion web-orria itzuliko du
		String ema = "";
		return ema;
	}
	
	public int String2Id(String pUrl) {
		// Url bat sartu eta bere indizea bueltatzen du
		int ema = 0;
		return ema;
	}
	
	public ArrayList<String> irteerakoEstekak(String pUrl)	{
		// post: web-orri baten izena emanda, estekatzen dituen web-orriak itzultzen ditu.
		Iterator<Web>itr = this.getIteradorea();
		while (itr.hasNext()) {
			Web w = itr.next();
			if (pUrl.contentEquals(w.getUrlWeb()))
			{
				// Falta resolver dudas para seguir por aqui
			}

		}
	}
	
	public ArrayList<String> word2Webs(String pGako){
		// pre: parametroa gako-hitz bat da
		// post:  gako-hitza daukaten web-orriak itzultzen ditu
		ArrayList<String> ema;
		return ema;
	}
	
	public ArrayList<String> web2Words(String pUrl){
		// post: web-orrian agertzen diren gako-hitzak itzultzen ditu
		ArrayList<String> ema;
		return ema;
	}
	
	
	

}
