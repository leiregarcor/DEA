package probak;

//import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlEnuntziatu1.GakoHitzZerrenda;

public class GakoHitzZerrendaTest {
	private static  GakoHitzZerrenda ghz;

	private File wordsFitxeroa ;
	
	@Before
	public void setUp() throws Exception {
		ghz = GakoHitzZerrenda.getNireGakoHitzZerrenda();
		wordsFitxeroa = new File ("resources\\words.txt");
	}

	@After
	public void tearDown() throws Exception {
		ghz = null;
		wordsFitxeroa = null;
	}

	@Test
	public void testFitxeroaKargatu() {
		try {
			ghz.fitxeroaKargatu(wordsFitxeroa);
			System.out.println("wordsFitxeroa sartu da");
		} catch (FileNotFoundException e) {
			System.out.println("wordsFitxeroa ez da sartu");
		}
	}

}
