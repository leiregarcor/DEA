package packlEnuntziatu2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packlEnuntziatu1.Web;


public class HitzaTest {
    private Hitza h;
    private Web w1, w2, w3;

    @Before
    public void setUp() throws Exception {
        h= new Hitza("leire");

        w1= new Web(0, "leireGarcia");
        w2= new Web(1, "martinAmezola");
        w3= new Web(2, "aitorSanJose");

        h.gehituWebBat(w1);
        h.gehituWebBat(w2);
        h.gehituWebBat(w3);
    }

    @After
    public void tearDown() throws Exception {
        h= null;

        w1= null;
        w2= null;
        w3= null;
    }

    @Test
    public void TestGakoWebInprimatu() {
        System.out.println(" TestGakoWebInprimatu ");
        h.gakoWebInprimatu();
    }

    @Test
    public void TestGakoWebInprimatu2() {
        System.out.println(" TestGakoWebInprimatu2 ");
        h.gakoWebInprimatu2();
    }
}