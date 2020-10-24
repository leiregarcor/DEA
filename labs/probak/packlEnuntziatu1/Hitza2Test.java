package packlEnuntziatu1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.*;

//import packlEnuntziatu1.GakoHitzZerrenda;
//import packlEnuntziatu1.Hitza;
//import packlEnuntziatu1.WebZerrenda;

import java.io.File;

public class Hitza2Test {
    private static  GakoHitzZerrenda ghz;
    private static WebZerrenda wz;
    private Hitza h;
    private File wordsFitxeroa ;
    private File webIndexFitxeroa ;

    @Before
    public void setUp() throws Exception {
        wz= WebZerrenda.getNireWebZerrenda();
        ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();

        webIndexFitxeroa = new File ("resources\\index.txt");
        wordsFitxeroa = new File ("resources\\words.txt");

        ghz.fitxeroaKargatu(wordsFitxeroa);
        wz.indexFitxeroaKargatu(webIndexFitxeroa);

        h= ghz.bilatuHitza("sport");
    }

    @After
    public void tearDown() throws Exception {
        wz=null;
        ghz= null;
        webIndexFitxeroa = null;
        wordsFitxeroa = null;
        h = null;
    }

    @Test
    public void gakoWebInprimatu() {
        h.gakoWebInprimatu();
    }
}