package probak;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packlEnuntziatu1.GakoHitzZerrenda;
import packlEnuntziatu1.Hitza;
import packlEnuntziatu1.WebZerrenda;

class HitzaTest {
	private static  GakoHitzZerrenda ghz;
	private static WebZerrenda wz;
	private Hitza h;
	private File wordsFitxeroa ;
	private File webIndexFitxeroa ;
	
	@BeforeEach
	void setUp() throws Exception {
		wz= WebZerrenda.getNireWebZerrenda();
		ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
				
	    webIndexFitxeroa = new File ("resources\\index.txt");
	    wordsFitxeroa = new File ("resources\\words.txt");
	    
	    ghz.fitxeroaKargatu(wordsFitxeroa);
	    wz.indexFitxeroaKargatu(webIndexFitxeroa);
	    
	    h= ghz.bilatuHitza("sport");
	}

	@AfterEach
	void tearDown() throws Exception {
		wz=null;
		ghz= null;
		webIndexFitxeroa = null;
		wordsFitxeroa = null;
		h = null;
	}

	@Test
	void testGakoWebInprimatu() {
		h.gakoWebInprimatu();
	}
}
