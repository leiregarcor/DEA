package packlEnuntziatu3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;

import java.util.ArrayList;

public class GraphTest {
    private WebZerrenda wz;
    private Web w1, w2, w3, w4, w5, w6, w0;
    private Graph g;

    @Before
    public void setUp() throws Exception {
        //hasieraketak
        wz= WebZerrenda.getNireWebZerrenda();

        w0= new Web(0, "a.com");
        w1= new Web(1, "b.com");
        w2= new Web(2, "c.com");
        w3= new Web(3, "d.com");
        w4= new Web(4, "e.com");
        w5= new Web(5, "f.com");
        w6= new Web(6, "g.com");

        //web-en esteken zerrendak bete:
            //a norekin lotuta
        w0.getEstekenZerrenda().add(w1); //b
        w0.getEstekenZerrenda().add(w2); //c
        w0.getEstekenZerrenda().add(w4); //e
            //b norekin lotuta
        w1.getEstekenZerrenda().add(w3);//d
            //c norekin lotuta
        w2.getEstekenZerrenda().add(w0);//a
            //d norekin lotuta
        w3.getEstekenZerrenda().add(w5);//f
            //e norekin lotuta
        w4.getEstekenZerrenda().add(w3);//d
        w4.getEstekenZerrenda().add(w6);//g
            //f norekin lotuta
        w5.getEstekenZerrenda().add(w6);//g
            //g norekin lotuta
        w6.getEstekenZerrenda().add(w5);//f

        //web-ak webZerrendan sartu
        wz.gehitu(w0);
        wz.gehitu(w1);
        wz.gehitu(w2);
        wz.gehitu(w3);
        wz.gehitu(w4);
        wz.gehitu(w5);
        wz.gehitu(w6);

        g = new Graph();
        g.grafoaSortu(wz);
    }

    @After
    public void tearDown() throws Exception {
        wz= null;

        w1= null;
        w2= null;
        w3= null;
        w4= null;
        w5= null;
        w6= null;
        w0= null;

        g= null;
    }

    @Test
    public void Test2Erlazionatuta() {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println(" TestErlazionatuta ");
        boolean ema;
        System.out.println("  ");
        System.out.println("  ");
        g.print();
        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w0.getUrlWeb() +" "+w0.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatuta(w0.getUrlWeb(), w0.getUrlWeb());
        System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w0.getUrlWeb() +" "+w4.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatuta(w0.getUrlWeb(), w4.getUrlWeb());
        System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w0.getUrlWeb() +" "+w5.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatuta(w0.getUrlWeb(), w5.getUrlWeb());
        System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w1.getUrlWeb() +" "+w5.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatuta(w1.getUrlWeb(), w5.getUrlWeb());
        System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w2.getUrlWeb() +" "+w4.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatuta(w2.getUrlWeb(), w4.getUrlWeb());
        System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

       System.out.println(" "+w4.getUrlWeb() +" "+w2.getUrlWeb()+"-rekin:    EMAITZA: false ");
       ema=g.erlazionatuta(w4.getUrlWeb(), w2.getUrlWeb());
       System.out.println(ema);

        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w5.getUrlWeb() +" "+w0.getUrlWeb()+"-rekin:    EMAITZA: false ");
        ema=g.erlazionatuta(w5.getUrlWeb(), w0.getUrlWeb());
        System.out.println(ema);
    }

    @Test
    public void Test1ErlazionatutaBidea() {
        ArrayList<String> ema;

        System.out.println(" TestErlazionatutaBidea ");
        System.out.println("  ");
        System.out.println("  ");

        System.out.println(" "+w1.getUrlWeb() +" "+w5.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatutaBidea(w1.getUrlWeb(), w5.getUrlWeb());
        for(String s : ema){
            System.out.println(" "+s);
        }

        System.out.println("  ");
        System.out.println("  ");
        System.out.println(" "+w0.getUrlWeb() +" "+w0.getUrlWeb()+"-rekin:    EMAITZA: true ");
        ema=g.erlazionatutaBidea(w0.getUrlWeb(), w0.getUrlWeb());
        for(String s : ema){
            System.out.println(" "+s);
        }

        System.out.println("  ");
        System.out.println("  ");
        System.out.println(" "+w4.getUrlWeb() +" "+w0.getUrlWeb()+"-rekin:    EMAITZA: false ");
        ema=g.erlazionatutaBidea(w4.getUrlWeb(), w0.getUrlWeb());
        if(ema.size()==0){
            System.out.println(" null da");
        }
        System.out.println("  ");
        System.out.println("  ");
    }
}