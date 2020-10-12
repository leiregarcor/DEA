package probak;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlEnuntziatu1.WebZerrenda;

public class WebZerrendaTest {
	private static WebZerrenda wz;
	private File webIndexFitxeroa ;
	private File webEstekaFitxeroa ;
	@Before
	public void setUp() throws Exception {
		wz= WebZerrenda.getNireWebZerrenda();
				
	    webIndexFitxeroa = new File ("resources\\index.txt");
	    webEstekaFitxeroa = new File ("resources\\pld-arcs-1-N.txt");
	}

	@After
	public void tearDown() throws Exception {
		wz=null;
		webIndexFitxeroa = null;
		webEstekaFitxeroa = null;
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
	}

	@Test
	public void testGehitu() {
		//JADA DAGOEN WEB BAT SARTU
		//EZ DAGOEN WEB BAT SARTU
	}

	@Test
	public void testEzabatu() {
		//EZABATU DAGOEN WEB BAT 
		//EZ DAGOEN WEB BAT EZABATU
	}

	@Test
	public void testListaOrdenatuta() {
		wz.listaOrdenatuta();
		System.out.println("testListaOrdenatuta");
	}

}
