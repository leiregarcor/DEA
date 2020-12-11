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
    private ArrayList<Integer>[] heldutakoakList;

    public PageRank() {
        this.d = 0.85;
        this.n = g.getTh().size();
        this.g = new Graph();
        this.heldutakoakList = new ArrayList[g.getAdjList().length];
        g.grafoaSortu(WebZerrenda.getNireWebZerrenda());
        HashMap<String, Double> zahar = new HashMap<>();
        HashMap<String, Double> berri = new HashMap<>();
    }


    public void heldutakoakBete(){
        /*
        * post: heldutakoakList hasieratu eta bete du.
        * heldutakoakList atributuan gordeko da nondik heltzen garen nodo bakoitzera.
        */
        for(int k=0; k<heldutakoakList.length ; k++){
            heldutakoakList[k]= new ArrayList<>();
        }
        for (int i=0; i<g.getAdjList().length; i++ ){
            for (int x:g.getAdjList()[i]){
                heldutakoakList[x].add(i);
            }
        }
    }


    public void hasieratuPageRank(){
        double balio = 1/n;
        for (String s:g.getKeys()){
            zahar.put(s, 0.0);
            berri.put(s,balio);
        }

    }

    public HashMap<String, Double> pageRank() {
        //POST: emaitza web-orri zerrendaren web-orri bakoitzaren PageRank algoritmoaren balioa da
        this.hasieratuPageRank();
        double dif=1;
        String lag;
        double balioa;
        while(dif>0.0001){
            zahar=berri;
            berri=new HashMap<String, Double>();
            for (int i=0; i<g.getKeys().length; i++){
                balioa=0;
                lag=g.getKeys()[i];
                for (int k=0; k<heldutakoakList[i].size(); k++){
                    balioa=balioa+ (zahar.get(heldutakoakList[i].get(k))/g.getAdjList()[heldutakoakList[i].get(k)].size())
                    lag=heldutakoakList[i].get(k);
                }
                berri.put(lag,)
            }



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
