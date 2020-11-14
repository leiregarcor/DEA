package packlEnuntziatu3;

import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
      HashMap<String, Integer> th; //HashMap sortu behar dugu non Key = url eta Value = indizea
      String[] keys;
      ArrayList<Integer>[] adjList;


	public void thBete (WebZerrenda lista){
		  ArrayList<Web> l = WebZerrenda.getNireWebZerrenda().hashMapaBihurtu();
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
            // KODEA INPLEMENTATU
		  this.thBete(lista);

            // 2. pausua: “keys” bete
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

 	    // 3. pausua: “adjList” bete
            // KODEA INPLEMENTATU           
		  adjList = new ArrayList[keys.length];
      }
	
      public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
      }
	
	public boolean erlazionatuta(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];

                 // KODEA INPLEMENTATU    
		
		return aurkitua;

	}
}
