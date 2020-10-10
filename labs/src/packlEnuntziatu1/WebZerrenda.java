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
	private ArrayList<Web>wZerrenda; // Esto es necesario?? Igual podemos hacer el values y meter aqui todo lo del HashMap
	private HashMap<String, Web> webMapa; //HashMap sortu behar dugu non Key = url eta Value = Web objektua
	//private ArrayList<String>urlZerrenda;// Hau zen url-ak ordenatzeko baina ez gaude ziur erabili behar den ala ez
	
	// eraikitzailea
	private WebZerrenda() {
		this.wZerrenda = new ArrayList<Web>(); //CREO QUE NO HAY QUE CREAR UNA INSTANCIA PORQUE PODEMOS USAR EL VALUES() [EL VALUES() DEVUELVE UNA COLLECCION, ES UN GENERICO¿] EN EL HASHMAP Y COPIARLO EN ESTE ALDAGAIA DE CLASE ARRAYLIST<WEB>
		//this.urlZerrenda= new ArrayList<String>();
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
	        	// Aqui tenemos que dividir la url en subgrupos empezando por subgrupos de 3
	        	// hasta el tamaño de la hitza-1 que seria el mas grande de los subgrupos.
	        	// Despues, tenemos que ir comprobando cada zati a ver si coincide en el hashmap
	        	// de GakoHitzZerrenda que se llama 'gakoMapa' y si devuelve null, es que no esta
	        	// si devuelve una Hitza, quiere decir que contiene esa hitza osea que tenemos 
	        	// que coger la web que estamos dividiendo, meterla en el hashmap de webs, nos devuelve una
	        	// web y la metemos a la lista de webs de la Hitza que nos ha devuelto el hashmap de 'gakoMapa'
	        	
	        	//primero dividimos la url en subgrupos
	        	
	        	int luz = zatiak[0].length(); // luz va a ser el tamaño de la url
	        	int iterazio;
	        	int dif = 3;
	        	Hitza atxe;
	        	String sub;	        	
	        	while (dif <= luz) 
	        	{
	        		iterazio = 0;
	        		while (iterazio <= luz - dif )
		        	{
		        		sub = zatiak[0].substring(iterazio, iterazio + dif);
		        		atxe = ghz.bilatuHitza(sub);
		        		if (atxe!=null) // Aurkitzen badu
		        		{
		        			// Esto lo que hace es si atxe, es decir, si el substring ese que hemos
		        			// metido devuelve un gakohitz, es decir, si contiene alguna hitza de la lista
		        			// cogemos la hitza esa (en este caso atxe) y cogemos la web cuya url estamos 
		        			// dividiendo y la metemos a la lista de webs que coinciden con la palabra atxe
		        			atxe.gehituWebBat(this.webMapa.get(zatiak[0]));
		        		}
		        		iterazio++;
		        	}
	        		dif++;
	        	}
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
	        while ((lerro = b.readLine())!=null)
	        {
	        	String zatiak1[] = lerro.split(" -->"); // Zatitzen dugu estekak eta indizea
	        	w=wz.bilatuId(Integer.parseInt(zatiak1[0]));//w-n gorde behar ditugu esteka guztiak
	        	if (zatiak1.length == 2)// zatiak1[1]!=null
	        	{
	        		String zatiak2[] = zatiak1[1].split(" ");
		        	luzera=zatiak2.length;
		        	i=1;
		        	while(i<=luzera-1) {
		        		w.getEstekenZerrenda().add(wz.bilatuId(Integer.parseInt(zatiak2[i])));
		        		i++;
		        	}
	        	}
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
	
	
		
	private void fitxeroaSortu() throws IOException{
		//post: Web-orrien zerrenda fitxategitan gordetzen du
		String ruta= "";
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
			fitxero= new FileWriter("");
			pw=new PrintWriter(fitxero);
			for(int i=0; i<wZerrenda.size();i++) {
				pw.println(bilatuId(i).getUrlWeb()+" " +i);
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
		this.wZerrenda.add(pWeb); // Web Zerrendan gehitzeko
		// Ez gaude ziur urlZerrenda beharrezkoa denentz. HashMapean .values() egin daitekeela.
		//urlZerrenda.add(pWeb.getUrlWeb()); // String zerrendan gehitzeko
		this.webMapa.put(pWeb.getUrlWeb(), pWeb); // HashMapan ere gehitzeko
	}
	
	public void ezabatu (String pUrl){	
		Web w=bilatuUrl(pUrl);
		if(w!=null) {
			webMapa.remove(pUrl);
			//urlZerrenda.remove(pUrl);
			this.wZerrenda.remove(w);
		}
	}
	
	public ArrayList<Web> webOrdenatuta(ArrayList<Web> pZerrenda){
		// post: web-orrien zerrenda itzultzen du, alfabetikoki ordenatuta
		// Voy a hacer que ordene alfabeticamente el array de objetos Web, si luego es el de Strings 
		// se cambia y ya.
		// Bon dia.
		ArrayList<Web> ordZerrenda= pZerrenda;
		return ordZerrenda;		
	}
	
	public String id2String(int pId){
		// Postbaldintza: osoko bat emanda, dagokion web-orria itzuliko du
		String ema = "";
		Web w=bilatuId(pId);
		if(w!=null) {
		ema=w.getUrlWeb();
		}
		return ema;
	}
	
	public int string2Id(String pUrl){
		// Url bat sartu eta bere indizea bueltatzen du
		int ema = -1;
		Web w=bilatuUrl(pUrl);
		if(w!=null) {
		ema=w.getId();
		}
		return ema;
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
	
	public ArrayList<Hitza> web2Words(String pUrl){
		// post: web-orrian agertzen diren gako-hitzak itzultzen ditu
//		ArrayList<Hitza> ema = new ArrayList<Hitza>();
//		return ema;
		Web w = this.bilatuUrl(pUrl);
		return w.getGakoZerrenda();		
	}
	
	
	  private String[] pasaArray() {
		String[] zerrenda= new String[wZerrenda.size()];
		int i=0;
		Iterator<Web> itr= this.getIteradorea();
		Web w=null;
		while(itr.hasNext()) {
			w=itr.next();
			zerrenda[i]=w.getUrlWeb();
			i++;
		}
		return zerrenda;
	}
	
	
	private void quickSort(String[] zerrenda, int hasiera, int bukaera) {
		if(bukaera-hasiera>0) {
			int indizeaZatiketa=zatiketa(zerrenda,hasiera,bukaera);
			quickSort(zerrenda,hasiera,indizeaZatiketa-1);
			quickSort(zerrenda,indizeaZatiketa+1,bukaera);
		}
	}
	
	private int zatiketa(String[] lista, int i, int f) {
		String lag=lista[i];
		int ezker=i;
		int eskuin=f;
		while(ezker<eskuin) {
			lag.toUpperCase();
			lista[ezker].toUpperCase();
			lista[eskuin].toUpperCase();
			while(lista[ezker].compareTo(lag)<=0 && ezker<eskuin)
				ezker++;
			while(lista[eskuin].compareTo(lag)>0)
				eskuin--;
			if(ezker<eskuin)
				swap(lista,ezker,eskuin);
		}
		lista[i]=lista[eskuin];
		lista[eskuin]=lag;
		return eskuin;
	}
	
	private void swap(String[] lista, int bat, int bi) {
		String temp=lista[bat];
		lista[bat]=lista[bi];
		lista[bi]=temp;
	}
	
	
	
	public String[] listaOrdenatuta() {
		String[] zerrenda= this.pasaArray();
		quickSort(zerrenda,0,zerrenda.length-1);
		return zerrenda;
	}
	
		
	
	
	// Metodos para probar a ver si funciona.
	
	
	public int getSize(){								
		return this.wZerrenda.size();
	}
	
}
