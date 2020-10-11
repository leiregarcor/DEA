package packlEnuntziatu1;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.*;
import java.util.*;

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
	    
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("**                 WEB KUDEAKETA APLIKAZIOA               **");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	    
		do {
		Scanner aukerak = null;		
		//aukerak pantailan inprimatzeko:
		File aukerakTestuaFile = new File("resources\\aukerak.txt");
		try {
			aukerak = new Scanner(aukerakTestuaFile);
			
		} catch (FileNotFoundException e) {
			System.out.println("Ez da aurkitu fitxategia");
		}

		while(aukerak.hasNextLine())		{ 
		   System.out.println(aukerak.nextLine());
		}
		aukerak.close();
	    
	
		int kasua = Teklatua.getNireTeklatua().irakurriAukera(1 , 8);
		switch(kasua) {
		case 1:
			//imprimir url de web, HAY QUE IMPLEMENTAR EL METODO 
			String s1= Teklatua.getNireTeklatua().irakurriString();
			System.out.println("	K1");
			break;
		case 2:
			System.out.println("	Txertaketa arrakastatsua izan da.");
			break;
		case 3:
			System.out.println("	Ezabaketa arrakastatsua izan da.");
			break;
		case 4:
			//WEB ORRIA SARTU
			//web HORREK ESTEKATZEN DITUEN orrien zerrenda imprimatu
			String s= "url"; //AQUI LLAMAMOS AL METODO PARA QUE META UN STRING POR TECLADO
			System.out.println("	Honako hau da "+ s +"web orrialdeak estekatzen dituen web orrien zerrenda: ");
			break;
		case 5:
			//GAKOHITZA SARTU
			//GAKO HITZA BARNEAN DUTEN WEB ORRIAK IMPRIMATU
			System.out.println("k5");
			break;
		case 6:
			System.out.println("	Fitxeroa eguneratu da.");
			break;
		case 7:
			System.out.println("	Web orrien zerrenda ordenatu da.");
			break;
		case 8:
			System.out.println("********************");
			System.out.println("********AGUR********");
			System.out.println("********************");
			System.exit(0);
			break;
		}
	}while(true);

	}//_____________________________main amaiera_______________________
    
	

}
