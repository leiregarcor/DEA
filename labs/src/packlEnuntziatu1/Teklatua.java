package packlEnuntziatu1;

import java.util.Scanner;

public class Teklatua {

	// atributuak
	private static Teklatua nireTeklatua = null;
	private Scanner sc;
	
	// eraikitzailea
	private Teklatua() {
		 this.sc=new Scanner(System.in);
	}
	
	// gainontzeko metodoak
	public static Teklatua getNireTeklatua() {
		if(nireTeklatua == null){
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua;
	}

	public  int irakurriAukera(int pNundik, int pNora){
		int emaitza =  -1;
        boolean denaOndo=false;
        do {	        
			String str = sc.nextLine();
			try{
				emaitza = Integer.parseInt(str);
				if( emaitza >pNora || emaitza<pNundik){
					throw new NumberFormatException();//sartzen duen balioa ez du balio
				}
				denaOndo=true;
			}catch (NumberFormatException e) { System.out.println("Sar ezazu zenbaki baliogarri bat:"); 
			}
        }while(!denaOndo);
        return emaitza;
      }
	
	public String irakurriString(){
		String mezua=this.sc.nextLine();		
		return mezua;
	}
}
