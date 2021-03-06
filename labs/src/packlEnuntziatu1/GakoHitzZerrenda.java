package packlEnuntziatu1;

import java.util.HashMap;
//import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class GakoHitzZerrenda {

	// atributuak
	private static GakoHitzZerrenda nireGakoHitzZerrenda = null;
	//private ArrayList<Hitza>ghZerrenda; // Ez dakigu behar dugun ala ez
	
	private HashMap<String, Hitza> gakoMapa; // HashMap bat sortu behar dugu Key = katea eta Value = Hitza objektua
	
	// eraikitzailea
	public GakoHitzZerrenda() {
		//this.ghZerrenda = new ArrayList<Hitza>(); //gako array-a sortu
		this.gakoMapa = new HashMap<String,Hitza>(); //gako mapa sortu
	}
	
	// gainontzeko metodoak
	
	public static GakoHitzZerrenda getNireGakoHitzZerrenda() {
		if(nireGakoHitzZerrenda == null){
			nireGakoHitzZerrenda = new GakoHitzZerrenda();
		}
		return nireGakoHitzZerrenda;
	}
	
	public Hitza bilatuHitza(String pGakoa) {
		return gakoMapa.get(pGakoa);
	}
	
	public void fitxeroaKargatu(File pFitxeroaWords) throws FileNotFoundException {
		// Pre: Fitxeroa jasotzen du words.txt
		
		// Post: GakoHitzZerrenda betetzen du, HashMapa betetzen du.
		FileReader fr = new FileReader (pFitxeroaWords);
        BufferedReader b = new BufferedReader(fr);
		
		String fila;
		
		try
		{
			while ((fila=b.readLine())!=null)
			{
				Hitza h = new Hitza(fila);
				//this.ghZerrenda.add(h); 
				this.gakoMapa.put(h.getKatea(), h);
			}
		}catch(Exception e){
	        e.printStackTrace();
	     }finally{ // Finally hau da fitxeroa ixteko zerbait txarto badoa.
	        try{                    
	           if( null != fr ){   
	              fr.close();     
	           }                  
	        }catch (Exception e2){ 
	           e2.printStackTrace();
	        }
	     }	
		
	}
	public HashMap<String, Hitza> getGakoMapa(){
		return gakoMapa;
	}
}
