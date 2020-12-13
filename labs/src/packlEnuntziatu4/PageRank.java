package packlEnuntziatu4;

import packlEnuntziatu1.GakoHitzZerrenda;
import packlEnuntziatu1.Hitza;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;
import packlEnuntziatu2.OrderedCircularLinkedList;
import packlEnuntziatu3.Graph;

import java.util.ArrayList;
import java.util.Collection;
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
        int aux;
        double balioa;
        while(dif>0.0001){
            dif=0;
            zahar=berri;
            berri=new HashMap<String, Double>();
            for (int i=0; i<g.getKeys().length; i++){
                balioa=0;
                lag=g.getKeys()[i];
                for (int k=0; k<heldutakoakList[i].size(); k++){
                    aux=heldutakoakList[i].get(k);
                    balioa=balioa+ ((zahar.get(aux)/g.getAdjList()[aux].size())*d);
                    //lag=heldutakoakList[i].get(k);
                }
                balioa=balioa+((1-d)/n);
                berri.put(lag,balioa);
                dif=dif+Math.abs(berri.get(lag)-zahar.get(lag));
            }

        }
        return berri;
    }


    public class Bikote implements Comparable<Bikote> {
        String web;
        Double pageRank;

        @Override
        public int compareTo(Bikote o) {
            if(pageRank==o.pageRank) {
                return 0;
            }else {
                if (pageRank<o.pageRank){
                    return -1;
                }else {
                    return 1;
                }
            }
        }
    }

    public ArrayList<Bikote> bilatzailea(String gakoHitz) {
        // Post: Emaitza emandako gako-hitza duten web-orrien zerrenda da, bere pagerank - aren arabera handienetik
        // txikienera ordenatuta (hau da, lehenengo posizioetan pagerank handiena duten web - orriak agertuko dira)
        OrderedCircularLinkedList<Bikote> lista= new OrderedCircularLinkedList<>("Page ranken lista");
        ArrayList<Bikote> ema= new ArrayList<>();
        Hitza h= GakoHitzZerrenda.getNireGakoHitzZerrenda().bilatuHitza(gakoHitz);
        for(int i=0; i<h.getWebLista().size(); i++){
            Web w= h.getWebLista().get(i);
            Bikote b= new Bikote();
            b.web=w.getUrlWeb();
            b.pageRank= berri.get(w.getUrlWeb());
            lista.add(b);
        }
        while (!lista.isEmpty()){
            ema.add(lista.removeFirst());
        }
        return ema;
    }

    public ArrayList<Bikote> bilatzailea(String gakoHitz1, String gakoHitz2){
        // Post: Emaitza emandako gako-hitzak dituzten web-orrien zerrenda da, bere pagerank-aren arabera handienetik
        //  txikienera ordenatuta(hau da, lehenengo posizioetan pagerank handiena duten web-orriak agertuko dira)
        ArrayList<Bikote> ema= new ArrayList<>();
        return ema;
    }
}
