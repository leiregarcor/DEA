package packlEnuntziatu1;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;




public class GakoHitzZerrenda {

	// atributuak
	private static GakoHitzZerrenda nireGakoHitzZerrenda = null;
	private ArrayList<Hitza>ghZerrenda;
	
	// eraikitzailea
	private GakoHitzZerrenda() {
		this.ghZerrenda = new ArrayList<Hitza>();
	}
	
	// gainontzeko metodoak
	
	
	private Iterator<Hitza> getIteradorea()
	{
		return this.ghZerrenda.iterator();
	}
	
	
	public static GakoHitzZerrenda getNireGakoHitzZerrenda() {
		if(nireGakoHitzZerrenda == null){
			nireGakoHitzZerrenda = new GakoHitzZerrenda();
		}
		return nireGakoHitzZerrenda;
	}
	
	
	public void fitxeroaKargatu(File pFitxeroaWords) throws FileNotFoundException {
		FileReader fr = new FileReader (pFitxeroaWords);
        BufferedReader b = new BufferedReader(fr);
		
		String fila;
		
		try
		{
			while ((fila=b.readLine())!=null)
			{
				Hitza h = new Hitza(fila);
				this.ghZerrenda.add(h); // Hitza sartzen dugu konprobatu gabe ea badagoen??
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
}
