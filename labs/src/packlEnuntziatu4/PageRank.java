package packlEnuntziatu4;

import packlEnuntziatu1.WebZerrenda;
import packlEnuntziatu3.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class PageRank {

    private Graph g;
    private double d;
    private double n;
    private HashMap<String, Double> zahar;
    private HashMap<String, Double> berri;

    public PageRank() {
        this.d = 0.85;
        this.n = g.getTh().size();
        this.g = new Graph();
        g.grafoaSortu(WebZerrenda.getNireWebZerrenda());
        HashMap<String, Double> zahar = new HashMap<>();
        HashMap<String, Double> berri = new HashMap<>();
    }


    public void hasieratuPageRank(){
        double balio = 1/n;
        for (String s:g.getKeys()){
            zahar.put(s, 0.0);
            berri.put(s,balio);
        }

    }

    public HashMap<String, Double> pageRank() {
        this.hasieratuPageRank();
        //POST: emaitza web-orri zerrendaren web-orri bakoitzaren PageRank algoritmoaren balioa da
        double dif=1;
        while(dif>0.0001){
            double balio = ((1-d)/n)+(d*(/));

        }



        return berri;
    }


    public class Bikote {
        String web;
        Double pageRank;
    }

    public ArrayList<Bikote> bilatzailea(String gakoHitz) {
        // Post: Emaitza emandako gako-hitza duten web-orrien zerrenda da, bere pagerank - aren arabera handienetik
        // txikienera ordenatuta (hau da, lehenengo posizioetan pagerank handiena duten web - orriak agertuko dira)
        ArrayList<Bikote> ema= new ArrayList<>();
        return ema;
    }

    public ArrayList<Bikote> bilatzailea(String gakoHitz1, String gakoHitz2){
        // Post: Emaitza emandako gako-hitzak dituzten web-orrien zerrenda da, bere pagerank-aren arabera handienetik
        //  txikienera ordenatuta(hau da, lehenengo posizioetan pagerank handiena duten web-orriak agertuko dira)
        ArrayList<Bikote> ema= new ArrayList<>();
        return ema;
    }
}
