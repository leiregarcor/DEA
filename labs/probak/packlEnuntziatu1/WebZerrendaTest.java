package packlEnuntziatu1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlEnuntziatu1.GakoHitzZerrenda;
import packlEnuntziatu1.Web;
import packlEnuntziatu1.WebZerrenda;

public class WebZerrendaTest {
	private static WebZerrenda wz;
	private static GakoHitzZerrenda ghz;
	private File wordsFitxeroa;
	private File webIndexFitxeroa ;
	private File webEstekaFitxeroa ;
	private Web w;
	
	@Before
	public void setUp() throws Exception {
		wz= WebZerrenda.getNireWebZerrenda();
		ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
				
	    webIndexFitxeroa = new File ("resources\\index.txt");
	    webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");
	    wordsFitxeroa = new File ("resources\\words.txt");
	    
	    ghz.fitxeroaKargatu(wordsFitxeroa);
	    wz.indexFitxeroaKargatu(webIndexFitxeroa);
		wz.arcFitxeroaKargatu(webEstekaFitxeroa);
		
		
		

	}

	@After
	public void tearDown() throws Exception {
		wz=null;
		ghz= null;
		webIndexFitxeroa = null;
		webEstekaFitxeroa = null;
		wordsFitxeroa = null;
		w = null;
		
		
	}

	@Test
	public void testIndexFitxeroaKargatu() {
		try {
			wz.indexFitxeroaKargatu(webIndexFitxeroa);
		} catch (FileNotFoundException e) {
			System.out.println("webIndexFitxeroa ez da sartu");
		}
		System.out.println("testIndexFitxeroaKargatu");
	}

	@Test
	public void testArcFitxeroaKargatu() {
		try {
			wz.arcFitxeroaKargatu(webEstekaFitxeroa);
		} catch (FileNotFoundException e) {
			System.out.println("webEstekaFitxeroa ez da sartu");
		}
		System.out.println("testArcFitxeroaKargatu");
	}

	@Test
	public void testBilatuUrl() {
		//HASIERAN 0-00.pl 0
		//ERDIAN
		//BUKAERAN
		//EZ DAGO
		
		// Lau kasuetan berdina emango du. HashMapean bilaketa O(1) kostua duelako.
		wz.bilatuUrl("0-00.pl"); // Hau lehenengo url-a da
		
	}

	@Test
	public void testGehitu() {
		//JADA DAGOEN WEB BAT SARTU
		w = new Web(0, "0-00.pl");
		wz.gehitu(w);
		//EZ DAGOEN WEB BAT SARTU
//		w = new Web(2039807, "bilbokoudala.com");
//		wz.gehitu(w);
		
		// Biak berdin tardatuko dute zeren eta hash mapean denbora konstantea.
		
	}

	@Test
	public void testEzabatu() {
		//EZABATU DAGOEN WEB BAT
		//EZ DAGOEN WEB BAT EZABATU
		// biak berdina O(1) kostua daukate:
		wz.ezabatu("auto-business-shop.de");
	}

	@Test
	public void testListaOrdenatuta() {
		wz.listaOrdenatuta();
		System.out.println("testListaOrdenatuta");
	}

}
