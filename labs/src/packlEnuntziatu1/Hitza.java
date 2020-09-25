package packlEnuntziatu1;

import java.util.ArrayList;

public class Hitza {
	private String katea;
	private ArrayList<Web> wLista;
	
	
	public Hitza (String pKatea)
	{
		this.katea = pKatea;
		this.wLista = new ArrayList<Web>();
	}
	
	public boolean gakoBerdinaDa(String pGakoa) {
		boolean ema= false;
		if(this.katea==pGakoa) {
			ema=true;
		}
		return ema;
		
	}

}
