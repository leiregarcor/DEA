package packlEnuntziatu1;

import java.util.ArrayList;

public class GakoHitzZerrenda {

	// atributuak
	private static GakoHitzZerrenda nireGakoHitzZerrenda = null;
	private ArrayList<Hitza>zerrenda;
	
	// eraikitzailea
	private GakoHitzZerrenda() {
		this.zerrenda = new ArrayList<String>();
	}
	
	// gainontzeko metodoak
	public static GakoHitzZerrenda getNireGakoHitzZerrenda() {
		if(nireGakoHitzZerrenda == null){
			nireGakoHitzZerrenda = new GakoHitzZerrenda();
		}
		return nireGakoHitzZerrenda;
	}
	
	public boolean gakoBerdinaDa(String pGakoa) {
		boolean ema= false;
		
		return ema;
		
	}
	
	
	public void fitxeroaKargatu(String pFitxeroa) {
		
	}
}
