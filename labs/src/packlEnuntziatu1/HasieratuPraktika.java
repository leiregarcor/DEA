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
	    Teklatua tk= Teklatua.getNireTeklatua();
	    Web w=null;
	    String s= " ";
	    boolean ondo= false;
	    
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
	    
	
		int kasua = tk.irakurriAukera(1 , 8);
		switch(kasua) {
		case 1: //Web bat bilatu.
			ondo=false;
			do{
				System.out.println("	Sar ezazu bilatu nahi duzun web orriaren url-a:");
				s= tk.irakurriString();
				w= wz.bilatuUrl(s);
				if(w!= null) {
					w.webInprimatu();
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun web orria ez da existitzen.");
				}
			}while(!ondo);
			break;
			
		case 2: //Web orri bat txertatu.
			ondo=false;
			do{
				System.out.println("	Sar ezazu txertatu nahi duzun web orriaren url-a:");
				s= tk.irakurriString();
				w= wz.bilatuUrl(s);
				if(w == null) {
					w= new Web(wz.getHSize()+1,s);
					wz.gehitu(w);
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun web orria jada existitzen da.");
				}
			}while(!ondo);
			System.out.println("	Txertaketa arrakastatsua izan da.");
			
			break;
			
		case 3: // Web orri bat ezabatu.			
			ondo=false;
			do{
				System.out.println("	Sar ezazu ezabatu nahi duzun web orriaren url-a:");
				s= tk.irakurriString();
				w= wz.bilatuUrl(s);
				if(w!= null) {
					wz.ezabatu(s);
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun web orria ez da existitzen.");
				}
			}while(!ondo);
			System.out.println("	Ezabaketa arrakastatsua izan da.");
			break;
			
		case 4:  //Web bat bat estekatzen dituen web orrien zerrenda ikusi.
			//WEB ORRIA SARTU
			//web HORREK ESTEKATZEN DITUEN orrien zerrenda imprimatu
			ondo=false;
			do{
				System.out.println("	Sar ezazu web orriaren url-a:");
				s= tk.irakurriString();
				w= wz.bilatuUrl(s);
				if(w!= null) {
					System.out.println("	Honako hau da "+ s +"web orrialdeak estekatzen dituen web orrien zerrenda: ");
					w.estekaZerendaInprimatu();
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun web orria ez da existitzen.");
				}
			}while(!ondo);
			break;
			
		case 5: //Gakohitz bat sartu bere web orrien zerrenda ikusteko.
			//GAKOHITZA SARTU
			//GAKO HITZA BARNEAN DUTEN WEB ORRIAK IMPRIMATU
			System.out.println("k5");
			break;
			
		case 6: //Web orrien zerrenda fitxeroa eguneratu.
			System.out.println("	Fitxeroa eguneratu da.");
			break;
			
		case 7: //Web zerrenda ordenatua lortu.
			System.out.println("	Web orrien zerrenda ordenatu da.");
			break;
			
		case 8: //Aplikaziotik irten.
			System.out.println("********************");
			System.out.println("********AGUR********");
			System.out.println("********************");
			System.exit(0);
			break;
		}
	}while(true);

	}//_____________________________main amaiera_______________________
    
	

}
