package packlEnuntziatu1;

public class Hitza {
	private String katea;
	private int luzeera;
	
	public Hitza (String pKatea)
	{
		this.katea = pKatea;
	}
	
	public boolean gakoBerdinaDa(String pGakoa) {
		boolean ema= false;
		if(this.katea==pGakoa) {
			ema=true;
		}
		return ema;
		
	}

}
