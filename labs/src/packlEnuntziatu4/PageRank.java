package packlEnuntziatu4;

import packlEnuntziatu1.*;
import packlEnuntziatu2.Node;
import packlEnuntziatu2.OrderedCircularLinkedList;
import packlEnuntziatu3.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PageRank {

    private Graph g;
    private double d;
    private double n;
    private HashMap<String, Double> zahar;
    private HashMap<String, Double> berri;
    private ArrayList<Integer>[] heldutakoakList;

    public PageRank() {
        this.d = 0.85;
        this.g = new Graph();
        g.grafoaSortu(WebZerrenda.getNireWebZerrenda());
        this.n = g.getTh().size();
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
        zahar = new HashMap<>();
        berri = new HashMap<>();
        heldutakoakBete();
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
            long start = System.currentTimeMillis();
            dif=0;
            zahar=berri;
            berri=new HashMap<String, Double>();
            for (int i=0; i<g.getKeys().length; i++){
                balioa=0;
                lag=g.getKeys()[i];
                for (int k=0; k<heldutakoakList[i].size(); k++){
                    aux=heldutakoakList[i].get(k);
                    balioa=balioa+ ((zahar.get(g.getKeys()[aux])/g.getAdjList()[aux].size())*d);
                    //lag=heldutakoakList[i].get(k);
                }
                balioa=balioa+((1-d)/n);
                berri.put(lag,balioa);
                dif=dif+Math.abs(berri.get(lag)-zahar.get(lag));
            }
            System.out.println("Diferentzia "+dif);
            long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
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
        Iterator<Bikote> itr= lista.iterator();
        while (itr.hasNext()){
            ema.add(lista.removeFirst());
        }
        return ema;
    }

    public ArrayList<Bikote> bilatzailea(String gakoHitz1, String gakoHitz2){
        // Post: Emaitza emandako gako-hitzak dituzten web-orrien zerrenda da, bere pagerank-aren arabera handienetik
        //  txikienera ordenatuta(hau da, lehenengo posizioetan pagerank handiena duten web-orriak agertuko dira
        OrderedCircularLinkedList<Bikote> lista= new OrderedCircularLinkedList<>("Page ranken lista");
        ArrayList<Web> lag1= GakoHitzZerrenda.getNireGakoHitzZerrenda().bilatuHitza(gakoHitz1).getWebLista();
        ArrayList<Web> lag2= GakoHitzZerrenda.getNireGakoHitzZerrenda().bilatuHitza(gakoHitz2).getWebLista();
        ArrayList<Bikote> ema= new ArrayList<>();
        int kont=0;
        boolean aurkitua=false;
        for (Web w:lag1){
            kont=0;
            aurkitua=false;
            while (kont< lag2.size() && !aurkitua){
                int i= w.getUrlWeb().compareTo(lag2.get(kont).getUrlWeb());
                if(i==0) {
                    Bikote b = new Bikote();
                    b.web = w.getUrlWeb();
                    b.pageRank = berri.get(w.getUrlWeb());
                    lista.add(b);
                    aurkitua=true;
                }
            }
        }
        Node<Bikote> unekoa=lista.getLast();
        while(unekoa.next!=lista.getLast()) {
            unekoa=unekoa.next;
            ema.add(unekoa.elem);
        }
        ema.add(lista.getLast().elem);
        return ema;
    }

    public Graph getGrafoa(){
        return this.g;
    }

    public static void main(String[] args) {

        File wordsFitxeroa = null;
        File webIndexFitxeroa = null;
        File webEstekaFitxeroa = null;

        wordsFitxeroa = new File ("resources\\words.txt");
        webIndexFitxeroa = new File ("resources\\index.txt");
        webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");

        GakoHitzZerrenda ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
        WebZerrenda wz = WebZerrenda.getNireWebZerrenda();


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

        PageRank p =new PageRank();
        p.pageRank();
        ArrayList<PageRank.Bikote> ema= p.bilatzailea("casino");
        for (int i=0; i<ema.size();i++){
            System.out.println("Web url: " + ema.get(i).web + " PageRank: " + ema.get(i).pageRank);
        }
    }
}
