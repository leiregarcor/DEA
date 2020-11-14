package packlEnuntziatu3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;

import static org.junit.Assert.*;

public class GraphTest {
    private WebZerrenda wz;
    private Web w1, w2, w3;
    @Before
    public void setUp() throws Exception {
        wz= WebZerrenda.getNireWebZerrenda();

        w1= new Web(0, "a.com");
        w2= new Web(1, "b.com");
        w3= new Web(2, "c.com");
    }

    @After
    public void tearDown() throws Exception {
        wz= null;

        w1= null;
        w2= null;
        w3= null;
    }

    @Test
    public void TestErlazionatuta() {
        System.out.println(" TestGakoWebInprimatu ");
    }
}