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
	}

	@Test
	public void testArcFitxeroaKargatu() {
		try {
			wz.arcFitxeroaKargatu(webEstekaFitxeroa);
		} catch (FileNotFoundException e) {
			System.out.println("webEstekaFitxeroa ez da sartu");
		}

	}

	@Test
	public void testBilatuUrl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGehitu() {
		fail("Not yet implemented");
	}

	@Test
	public void testEzabatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaOrdenatuta() {
		fail("Not yet implemented");
	}

}
