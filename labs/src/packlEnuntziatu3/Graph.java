package packlEnuntziatu3;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Graph {
      HashMap<String, Integer> th; //HashMap, non Key = url eta Value = indizea
      String[] keys;
      ArrayList<Integer>[] adjList;

	public Graph() {}

	public ArrayList<Integer>[] getAdjList(){
		return adjList;
	}

	public HashMap<String, Integer> getTh(){
		return this.th;
	}

	public String[] getKeys() {
		return keys;
	}

	public void thBete (WebZerrenda lista){
		Collection<Web> c= lista.getHM().values();
		ArrayList<Web> l= new ArrayList<>(c);
		this.th = new HashMap<>();
		int i =0;
		for (Web w :l){
		  	this.th.put(w.getUrlWeb(),i);
		  	i++;
		  }
	  }

	  public void grafoaSortu(WebZerrenda lista){
		// Post: web-en zerrendatik grafoa sortu, Nodoak web-en url-ak dira
            // 1. pausua:  “th” bete
		  this.thBete(lista);
            // 2. pausua: “keys” bete
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;
 	    // 3. pausua: “adjList” bete
		  adjList = new ArrayList[keys.length];
		  Web w= null;
		  ArrayList<Web> aux = new ArrayList<>();
		  int kont=0;
		  for(String s: keys){
		  	w = lista.bilatuUrl(s);
		  	aux = w.getEstekenZerrenda();
		  	ArrayList<Integer> berria = new ArrayList<>();
		  	for(Web w1 : aux){
				berria.add(th.get(w1.getUrlWeb()));
		  	}
		  	adjList[kont]=berria;
		  	kont++;
		  }
	}
	
      public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
      }
	
	public boolean erlazionatuta(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<>();
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
		for(int k=0; k<aztertuak.length;k++) aztertuak[k] = false;
		aztertuGabeak.add(pos1); //aztertuGabeen ilararen bukaeran sartu
		aztertuak[pos1]= true; //aztertuen array-an true jarri
		if (pos1 == pos2) aurkitua = true;
		int unekoa= pos1;
		ArrayList<Integer> lag = null;
		while(!aurkitua && !aztertuGabeak.isEmpty()){
			//aurkitu ez dugun bitartean edo pila hutsa den bitartean loop-ean sartu
			unekoa= aztertuGabeak.remove();
			lag = adjList[unekoa]; //aztertzen ari garen nodoaren  bizilagunak lortu
			//aztertuak arrayan true sartuko dugu nodoen indizeetan, baita aztertu gabeen ilaran sartu ere:
			for (int biziLag : lag){
				if (!aztertuak[biziLag]) {//ez bada tratatua izan
					aztertuak[biziLag] = true;
					aztertuGabeak.add(biziLag);
				}
				if(biziLag==pos2){ //amaierako nodoa unekoaren bizilagunen bat bada, aurkitua eta loop handia amaitu
					aurkitua= true;
				}
			}
		}
		return aurkitua;
	}

	public  ArrayList<String> erlazionatutaBidea(String a1, String a2){
		ArrayList<String> ema= new  ArrayList<String>();
		Queue<Integer> aztertuGabeak = new LinkedList<>();
		Integer[] bidea = new Integer[th.size()];
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
		for(int k=0; k<aztertuak.length;k++){
			aztertuak[k]=false;
		}
		aztertuGabeak.add(pos1); //aztertuGabeen ilararen bukaeran sartu
		aztertuak[pos1]= true; //aztertuen array-an true jarri
		if (pos1 == pos2) aurkitua = true;
		int unekoa= pos1;
		ArrayList<Integer> lag = null;
		while(!aurkitua && !aztertuGabeak.isEmpty()){
			//aurkitu ez dugun bitartean edo pila hutsa den bitartean loop-ean sartu
			unekoa= aztertuGabeak.remove();
			lag = adjList[unekoa]; //aztertzen ari garen nodoaren  bizilagunak lortu ditugu
			//aztertuak arrayan true sartuko dugu nodoen indizeetan, baita aztertu gabeen ilaran sartu ere:
			for (int biziLag : lag){
				//bidean jarri ze nodotik heldu garen
				if (!aztertuak[biziLag]) {//ez bada tratatua izan
					aztertuak[biziLag] = true;
					aztertuGabeak.add(biziLag);
					bidea[biziLag]=unekoa;
				}
				if(biziLag==pos2){ //amaierako nodoa unekoaren bizilagunen bat bada, aurkitua eta loop handia amaitu
					aurkitua= true;
				}
			}
		}
		if (aurkitua){
			if(pos1==pos2){//nodo bera badira
				ema.add(keys[pos1]);
				System.out.println("Hasierako eta amaierko nodoak berdinak dira ");
			}
			else{//nodo desberdinak badira
				Stack<String> pila= new Stack<String>();
				int oraingoa=pos2;
				pila.push(keys[oraingoa]);
				while(oraingoa!=pos1){
					oraingoa= bidea[oraingoa];
					pila.push(keys[oraingoa]);
				}
				System.out.println("Bidea hau da: ");
				while(!pila.isEmpty()){
					System.out.println(pila.peek());
					ema.add(pila.pop());
				}
			}
		}
		else{//biderik ez badago
			System.out.println("Ez dago biderik");
		}
		return ema;
	}


	public void xAldizDeitu(){
		Random r= new Random();
		int random1= 0;
		int random2= 0;
		long start = System.currentTimeMillis();
		for (int i=0; i<100; i++){
			random1= r.nextInt(keys.length-1);
			random2= r.nextInt(keys.length-1);
			erlazionatuta(keys[random1],keys[random2]);
		}
		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	}

	public static void main(String[] args) {
		WebZerrenda w = WebZerrenda.getNireWebZerrenda();
		File webIndexFitxeroa = null;
		File webEstekaFitxeroa = null;
		webIndexFitxeroa = new File ("resources\\index.txt");
		webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");
		try {
			w.indexFitxeroaKargatu(webIndexFitxeroa);
			w.arcFitxeroaKargatu(webEstekaFitxeroa);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Graph g = new Graph();
		g.grafoaSortu(w);
		System.out.println("Erlazionatuta:");
		System.out.println(g.erlazionatuta(g.keys[10], g.keys[0]));
		System.out.println(" ");
		System.out.println("ErlazionatutaBidea biderik gabe:");
		g.erlazionatutaBidea("0-5.co.il", g.keys[0]);
		System.out.println(" ");
		System.out.println("ErlazionatutaBidea bide zuzenarekin:");
		g.erlazionatutaBidea("0-chat.com", "0-deai.com");
		System.out.println(" ");
		System.out.println("Erlazionatuta bidea random:");
		g.erlazionatutaBidea(g.keys[20], g.keys[10]);
		System.out.println(" ");
		System.out.println("Erlazionatuta bidea nodo berarekin");
		g.erlazionatutaBidea(g.keys[20],g.keys[20]);
		System.out.println(" ");
		System.out.println("Erlazionatuta bidea random:");
		g.erlazionatutaBidea(g.keys[234565], g.keys[17660]);
		System.out.println(" ");
		System.out.println("Erlazionatuta 100 aldiz exekutatzeko behar duen denbora");
		g.xAldizDeitu();
	}

}
