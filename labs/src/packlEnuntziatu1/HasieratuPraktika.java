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
		
		
		wordsFitxeroa = new File ("resources\\words.txt");
	    webIndexFitxeroa = new File ("resources\\index.txt");
	    webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");
	    
	    // Aqui metemos las palabras de words.txt en hitzas y luego en GakoHitzZerrenda
	    
	    GakoHitzZerrenda ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
	    WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
	    
	    try {
	    	
	    	// Lehenik fitxeroen karga egiten dugu.
			ghz.fitxeroaKargatu(wordsFitxeroa);
			
			wz.indexFitxeroaKargatu(webIndexFitxeroa);
			
			wz.arcFitxeroaKargatu(webEstekaFitxeroa);
		
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			
			
//			System.out.println(wz.getSize());
			
			
			
			// Falta meter aqui para meter las webs para meter las redirecciones (los otros dos ficheros)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

	}//_____________________________main amaiera_______________________
    
	
	public void menuaHasieratu()
    {
    	//TODO
		
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("**                 WEB KUDEAKETA APLIKAZIOA               **");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Kaixo, zer egin nahi duzu?");
		System.out.println("");
		System.out.println("  1)  Web bat bilatu."); 
		
		// busquedas parecidas utilizando gakohitzas
		
		
		// Dentro de esto te pedira que metas el id o la url, identificamos a ver si es numero o string lo que ha metido y si 
		// es numero buscamos con el bilatuId() en el ArrayList de webs si mete un String lo buscamos en el HashMap
		System.out.println("  2)  Web orri bat txertatu.");
		System.out.println("  3)  Web orri bat ezabatu.");
		System.out.println("  4)  Web bat bat estekatzen dituen web orrien zerrenda ikusi.");
		// Aunque tenga 1000000 millones de estekas tenemos que imprimir todo
		// tenemos que implementar el metodo para que lo imprima
		System.out.println("  5)  Gakohitz bat sartu bere web orrien zerrenda ikusteko.");
		System.out.println("  6)  Web orrien zerrenda fitxeroa eguneratu.");
		System.out.println("  7)  Web zerrenda ordenatua lortu.");
		
		
    }

}
