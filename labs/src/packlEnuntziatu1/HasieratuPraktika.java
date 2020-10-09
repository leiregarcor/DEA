package packlEnuntziatu1;

import java.io.File;
import java.io.FileNotFoundException;

public class HasieratuPraktika {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File wordsFitxeroa = null;
		File webIndexFitxeroa = null;
		File webEstekaFitxeroa = null;

		// El FileReader y el BufferReader se meten dentro de GakoHitzZerrenda y de WebZerrenda.
	    
	    wordsFitxeroa = new File ("C:\\Fitxeroak\\words.txt");
	    webIndexFitxeroa = new File ("C:\\Fitxeroak\\index.txt");
	    webEstekaFitxeroa = new File ("C:\\Fitxeroak\\pld-arcs-1-N.txt");
	    
	    // Aqui metemos las palabras de words.txt en hitzas y luego en GakoHitzZerrenda
	    
	    GakoHitzZerrenda ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
	    WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
	    
	    try {
	    	
			ghz.fitxeroaKargatu(wordsFitxeroa);
			
			wz.indexFitxeroaKargatu(webIndexFitxeroa);
			
			wz.arcFitxeroaKargatu(webEstekaFitxeroa);
		
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			
			
			System.out.println(wz.getSize());
			
			
			
			// Falta meter aqui para meter las webs para meter las redirecciones (los otros dos ficheros)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    
	    
	    
	    
	    

	}

}
