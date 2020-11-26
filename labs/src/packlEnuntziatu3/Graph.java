package packlEnuntziatu3;

import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;

import java.util.*;

public class Graph {
	
      HashMap<String, Integer> th; //HashMap sortu behar dugu non Key = url eta Value = indizea
      String[] keys;
      ArrayList<Integer>[] adjList;

	public Graph() {
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
		// Post: web-en zerrendatik grafoa sortu
		//       Nodoak web-en url-ak dira
		
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
			lag = adjList[unekoa]; //aztertzen ari garen nodoaren  bizilagunak lortu ditugu
			//aztertuak arrayan true sartuko dugu nodoen indizeetan, baita aztertu gabeen ilaran sartu ere:
			for (int biziLag : lag){
				if (!aztertuak[biziLag]) {//ez bada tratatua izan
					aztertuak[biziLag] = true;
					aztertuGabeak.add(biziLag);
				}
				if(biziLag==pos2){ //amaierako nodoa unekoaren bizilagunen bat bada, aurkitua true eta loop-a amaitu
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
				if(biziLag==pos2){ //amaierako nodoa unekoaren bizilagunen bat bada, aurkitua true eta loop-a amaitu
					aurkitua= true;
				}
			}
		}

		if (aurkitua){
			if(pos1==pos2){
				ema.add(keys[pos1]);
				System.out.println(" Hasierako eta amaierko nodoak berdinak dira ");
			}
			else{
				Stack<String> pila= new Stack<String>();
				int oraingoa=pos2;
				pila.push(keys[oraingoa]);
				while(oraingoa!=pos1){
					oraingoa= bidea[oraingoa];
					pila.push(keys[oraingoa]);
				}
				System.out.println(" Bidea hau da: ");
				while(!pila.isEmpty()){
					System.out.println(pila.peek());
					ema.add(pila.pop());
				}
			}
		}
		else{
			System.out.println("  Ez dago biderik");
		}
		return ema;
	}


	public static void main(String[] args) {
		WebZerrenda w = WebZerrenda.getNireWebZerrenda();
		Graph g = new Graph();
		g.grafoaSortu(w);
		System.out.println(g.erlazionatuta(g.keys[10], g.keys[0]));

	}

}
