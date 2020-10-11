package packlEnuntziatu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.*;
import java.util.*;

public class HasieratuPraktika {

	public static void main(String[] args) {
		
		File wordsFitxeroa = null;
		File webIndexFitxeroa = null;
		File webEstekaFitxeroa = null;

		wordsFitxeroa = new File ("resources\\words.txt");
	    webIndexFitxeroa = new File ("resources\\index.txt");
	    webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");
	    
	    GakoHitzZerrenda ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
	    WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
	    Teklatua tk= Teklatua.getNireTeklatua();
	    Web w=null;
	    String s= " ";
	    boolean ondo= false;
	    Hitza h=null;
	    
	    try {	    	
	    	// Lehenik fitxeroen karga egiten dugu.
			ghz.fitxeroaKargatu(wordsFitxeroa);			
			wz.indexFitxeroaKargatu(webIndexFitxeroa);			
			wz.arcFitxeroaKargatu(webEstekaFitxeroa);
					
			System.out.println("");
			System.out.println("");
			System.out.println("");

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
			ondo=false;
			do{
				System.out.println("	Sar ezazu web orriaren url-a:");
				s= tk.irakurriString();
				w= wz.bilatuUrl(s);
				if(w!= null) {
					System.out.println("	Honako hau da "+ s +" web orrialdeak estekatzen dituen web orrien zerrenda: ");
					w.estekaZerendaInprimatu();
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun web orria ez da existitzen.");
				}
			}while(!ondo);
			break;
			
		case 5: //Gakohitz bat sartu bere web orrien zerrenda ikusteko.
			ondo=false;
			do{
				System.out.println("	Sar ezazu gako-hitza:");
				s= tk.irakurriString();
				h= ghz.bilatuHitza(s);
				if(h!= null) {
					System.out.println("	Honako hau da "+ s +" gako-hitza duten web orrien zerrenda: ");
					h.gakoWebInprimatu();
					ondo=true;
				}
				else {
					System.out.println("	Sartu duzun gako-hitza ez da existitzen.");
				}
			}while(!ondo);
			break;
			
		case 6: //Web orrien zerrenda fitxeroa eguneratu.
			try {
				wz.fitxeroaEguneratu();
				System.out.println("	Fitxeroa eguneratu da.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 7: //Web zerrenda ordenatua lortu.
			wz.listaOrdenatuta();
			System.out.println("	Web orrien zerrenda ordenatu da.");
			break;
			
		case 8: //Aplikaziotik irten.	
			System.out.println("************************************************************");
			System.out.println("************************************************************");
			System.out.println("****************************AGUR****************************");
			System.out.println("************************************************************");
			System.out.println("************************************************************");			
			System.exit(0);
			break;
		}
	}while(true);

	}//_____________________________main amaiera_______________________    
}
