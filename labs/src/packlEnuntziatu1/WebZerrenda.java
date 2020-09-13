package packlEnuntziatu1;
import java.util.*;
public class WebZerrenda {
	
	// atributuak
	private static WebZerrenda nireWebZerrenda = null;
	private ArrayList<Web>zerrenda;
	
	// eraikitzailea
	private WebZerrenda() {
		this.zerrenda = new ArrayList<Web>();
	}
	
	// gainontzeko metodoak
	public static WebZerrenda getNireWebZerrenda() {
		if(nireWebZerrenda == null){
			nireWebZerrenda = new WebZerrenda();
		}
		return nireWebZerrenda;
	} 
	
	public void fitxeroaKargatu(String pFitxeroa) {
		
	}
	
	public void fitxeroaEguneratu() {}
	
	public Web bilatu(String pUrl) {
		Web ema=null;
		
		return ema;
	} 
	public void gehitu (Web pWeb) {}
	
	public void ezabatu (String pUrl) {}
	
	public ArrayList<String> webOrdenatuta(){
		ArrayList<String> ema;
		return ema;		
	}
	
	public String id2String(int pId) {
		String ema;
		return ema;
	}
	
	public int String2Id( String pUrl) {
		int ema;
		return ema;
	}
	
	public ArrayList<String> irteerakoEstekak( String pUrl){
		ArrayList<String> ema;
		return ema;
	}
	
	public ArrayList<String> word2Webs(String pGako){
		ArrayList<String> ema;
		return ema;
	}
	
	public ArrayList<String> web2Words(String pUrl){
		ArrayList<String> ema;
		return ema;
	}
	
	
	

}
