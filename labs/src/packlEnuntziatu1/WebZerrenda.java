package packlEnuntziatu1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class WebZerrenda {
	
	// atributuak
	private static WebZerrenda nireWebZerrenda = null;
	private ArrayList<Web>wZerrenda; 
	private HashMap<String, Web> webMapa; //HashMap sortu behar dugu non Key = url eta Value = Web objektua
		
	// eraikitzailea
	private WebZerrenda() {
		this.wZerrenda = new ArrayList<Web>(); 
		this.webMapa = new HashMap<String, Web>();
	}
	
	// gainontzeko metodoak
	private Iterator<Web> getIteradorea(){
		return this.wZerrenda.iterator();
	}
	
	public static WebZerrenda getNireWebZerrenda() {
		if(nireWebZerrenda == null){
			nireWebZerrenda = new WebZerrenda();
		}
		return nireWebZerrenda;
	} 
	
	public void indexFitxeroaKargatu(File pIndexFitxeroa) throws FileNotFoundException {
		//Metodo hau jasotzen du: Fitxeroa web orrien url-ekin eta indizeekin.
		//Metodo hau sartzen du informazio hori web objektuetan, gero web zerrendan sartzeko
		// eta baita ere string en zerrendan (geroago alfabetikoki ordenatu beharko duguna) eta 
		// HashMapean sartuko duguna
		
		FileReader fr = new FileReader (pIndexFitxeroa);
        BufferedReader b = new BufferedReader(fr);
        
        String lerro;
    	WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
    	GakoHitzZerrenda ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
    	
		try {
	        while ((lerro = b.readLine())!=null)
	        {
	        	String zatiak[] = lerro.split(" "); // Zatitzen dugu web url eta indizea
	        	// Sortzen dugu Web objektu bat eta sartzen dugu indizea eta url parametro bezala
	        	Web w = new Web(Integer.parseInt(zatiak[1]), zatiak[0]);
	        	//gehitzen dugu web zerrendara
	        	wz.gehitu(w);
	        	int luz = zatiak[0].length(); 
	        	int iterazio;
	        	int dif = 3;
	        	Hitza atxe;
	        	String sub;	        	
	        	while (dif <= luz){
	        		iterazio = 0;
	        		while (iterazio <= luz - dif ){
		        		sub = zatiak[0].substring(iterazio, iterazio + dif);
		        		atxe = ghz.bilatuHitza(sub);
		        		if (atxe!=null) { // Aurkitzen badu		        		
		        			atxe.gehituWebBat(this.webMapa.get(zatiak[0]));
		        		}
		        		iterazio++;
		        	}
	        		dif++;
	        	}
	        }
		}catch(Exception e){
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
	
	public void arcFitxeroaKargatu(File pWebEstekaFitxeroa) throws FileNotFoundException {
		//Pre: Metodo hau jasotzen du: Fitxeroa web orrien id-ekin eta estekatzen dituen web-en indizeekin.
		
		// Post: Web bakoitzaren esteka zerrendak osatzen ditu
		
		FileReader fr = new FileReader (pWebEstekaFitxeroa);
        BufferedReader b = new BufferedReader(fr);
        
        String lerro;
        Web w=null;
        int luzera=0;
        int i;
    	WebZerrenda wz = WebZerrenda.getNireWebZerrenda();
    	
		try {
	        while ((lerro = b.readLine())!=null){
	        	String zatiak1[] = lerro.split(" -->"); // Zatitzen dugu estekak eta indizea
	        	w=wz.bilatuId(Integer.parseInt(zatiak1[0]));//w-n gorde behar ditugu esteka guztiak
	        	if (zatiak1.length == 2){// zatiak1[1]!=null
	        		String zatiak2[] = zatiak1[1].split(" ");
		        	luzera=zatiak2.length;
		        	i=1;
		        	while(i<=luzera-1) {
		        		w.getEstekenZerrenda().add(wz.bilatuId(Integer.parseInt(zatiak2[i])));
		        		i++;
		        	}
	        	}
	        }
		}catch(Exception e){
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
	
	private void fitxeroaSortu() throws IOException{
		//post: Web-orrien zerrenda fitxategitan gordetzen du
		String ruta= "resources\\fitxeroBerria.txt";
		File fitxeroa= new File(ruta);
		BufferedWriter bw;
		if(fitxeroa.exists()) {
			bw = new BufferedWriter(new FileWriter(fitxeroa));
		}else {
			bw = new BufferedWriter(new FileWriter(fitxeroa));
		}
		bw.close();
	}
	
	public void fitxeroaEguneratu() throws IOException {
		FileWriter fitxero= null;
		PrintWriter pw=null;
		fitxeroaSortu();
		try {
			fitxero= new FileWriter("resources\\fitxeroBerria.txt");
			pw=new PrintWriter(fitxero);
			Collection<Web> c= this.webMapa.values();
			ArrayList<Web> list= new ArrayList<>(c);
			 // Hash mapeko balioak arrayList<Web>n gorde
			
			for(int i=0; i<list.size();i++) {
				pw.println(list.get(i).getUrlWeb()+" " +i);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=fitxero) {
					fitxero.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public Web bilatuUrl(String pUrl){				 
		// Pre: Url string bat sartzen da.		
		// Post: Bueltatzen du Web objektua url hori duena bere url atributuan.
		return this.webMapa.get(pUrl);		
	}
	
	public Web bilatuId(int pId){     				  
		Web ema=null;
		if(pId>=0 && pId<wZerrenda.size()) {
			ema=wZerrenda.get(pId);
		}
		return ema;		
	}
	
	public void gehitu (Web pWeb){
		this.wZerrenda.add(pWeb);
		//urlZerrenda.add(pWeb.getUrlWeb()); // String zerrendan gehitzeko
		this.webMapa.put(pWeb.getUrlWeb(), pWeb); // HashMapan ere gehitzeko
	}
	
	public void ezabatu (String pUrl){	
		webMapa.remove(pUrl);
	}
	
	public ArrayList<Web> irteerakoEstekak(String pUrl){
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
		// post:  gako-hitza daukaten web-orriak itzultzen ditu eta web-orrien zerrendan sartzen du
		ArrayList<Web> ema = new ArrayList<Web>();
		Iterator<Web>itr = this.getIteradorea();
		Web w;
		while (itr.hasNext()){
			w = itr.next();
			if (w.getUrlWeb().contains(pGako))	{
				w.getGakoZerrenda().add(GakoHitzZerrenda.getNireGakoHitzZerrenda().bilatuHitza(pGako));
				ema.add(w);
			}
		}
		return ema;
	}
	
//	public ArrayList<Hitza> web2Words(String pUrl){
//		// post: web-orrian agertzen diren gako-hitzak itzultzen ditu
//		Web w = this.bilatuUrl(pUrl);
//		return w.getGakoZerrenda();		
//	}	
	
	private void quickSort(Web[] zerrenda, int hasiera, int bukaera) {
		if(bukaera-hasiera>0) {
			int indizeaZatiketa=zatiketa(zerrenda,hasiera,bukaera);//error
			quickSort(zerrenda,hasiera,indizeaZatiketa-1); //error
			quickSort(zerrenda,indizeaZatiketa+1,bukaera);
		}
	}
	
	private int zatiketa(Web[] lista, int i, int f) {
		Web lag1=lista[i];
		lista[i]= lista[i+(f-i)/2];
		lista[i+(f-i)/2]=lag1;
		Web lag= lista[i];
		int ezker=i;
		int eskuin=f;
		while(ezker<eskuin) {
			while(lista[ezker].getUrlWeb().compareToIgnoreCase(lag.getUrlWeb())<=0 && ezker<eskuin)
				ezker++;
			while(lista[eskuin].getUrlWeb().compareToIgnoreCase(lag.getUrlWeb())>0)
				eskuin--;
			if(ezker<eskuin)
				swap(lista,ezker,eskuin);
		}
		lista[i]=lista[eskuin];
		lista[eskuin]=lag;
		return eskuin;
	}
	
	private void swap(Web[] lista, int ezker, int eskuin) {
		Web temp=lista[ezker];
		lista[ezker]=lista[eskuin];
		lista[eskuin]=temp;
	}	
	
	public Web[] listaOrdenatuta() {
		Collection<Web> c= this.webMapa.values();
		Web[] zerrenda= c.toArray(new Web[c.size()]);
		quickSort(zerrenda,0,zerrenda.length-1);
		return zerrenda;
	}

	public ArrayList<Web> hashMapaBihurtu (){
		Collection<Web> c= this.webMapa.values();
		ArrayList<Web> l= new ArrayList<>(c);
		return l;
	}
	// Metodos para probar a ver si funciona.
	
	
	public int getSize(){								
		return this.wZerrenda.size();
	}


	public int getHSize(){								
		return this.webMapa.size();
	}
	
}
