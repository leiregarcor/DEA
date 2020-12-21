package packlEnuntziatu4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;
import packlEnuntziatu2.Hitza;
import packlEnuntziatu3.Graph;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PageRankTest {

    private WebZerrenda wz;
    private Web w1, w2, w3, w0;
    private Graph g;
    private Hitza h0;
    private PageRank p;


    @Before
    public void setUp() throws Exception {
        //hasieraketak
        wz= WebZerrenda.getNireWebZerrenda();
        w0= new Web(0, "a.com");
        w1= new Web(1, "b.com");
        w2= new Web(2, "c.com");
        w3= new Web(3, "d.com");

        //web-en esteken zerrendak bete:
        //a norekin lotuta
        w0.getEstekenZerrenda().add(w1); //b
        w0.getEstekenZerrenda().add(w2); //c
        //b norekin lotuta
        w1.getEstekenZerrenda().add(w3);//d
        //c norekin lotuta
        w2.getEstekenZerrenda().add(w3);//d
        w2.getEstekenZerrenda().add(w1);//b
        //d norekin lotuta
        w3.getEstekenZerrenda().add(w2);//c

        //web-ak webZerrendan sartu
        wz.gehitu(w0);
        wz.gehitu(w1);
        wz.gehitu(w2);
        wz.gehitu(w3);
        //grafoa sortzen da pagerank klasean
        /**
         *     A----->B
         *     |   🡥  |
         *     ↓ /    ↓
         *     C<---->D
         * */
        p = new PageRank();
    }

    @After
    public void tearDown() throws Exception {
        wz= null;
        w1= null;
        w2= null;
        w3= null;
        w0= null;
        g= null;
        p=null;
    }


    @Test
    public void pageRank() {
        /**  EMAITZA:
        *    A---1
        *    B---2
        *    C---3
        *    D---4        */

        System.out.println("  ");
        System.out.println(" TestpageRank ");

        System.out.println("  ");
        System.out.println(" GRAFOA ");

        System.out.println("  ");
        System.out.println(" A----->B");
        System.out.println(" |   \uD83E\uDC65  |");
        System.out.println(" ↓ /    ↓");
        System.out.println(" C<---->D");
        System.out.println("  ");
        System.out.println("  ");

        HashMap<String, Double>  ema= p.pageRank();

        System.out.println(ema.values());
        System.out.println(ema.keySet());

    }

    @Test
    public void bilatzailea() {
    }

    @Test
    public void testBilatzailea() {
    }
}