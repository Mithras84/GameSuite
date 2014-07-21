package memory;

import java.util.ArrayList;
import java.util.Random;

public class Memory {
	/**
	 * Klass om het memory spel te beheren.
	 * 
	 * @author Koen
	 */
	private int moeilijkheid = 8;
	
	ArrayList<Kaarten> kaarten = new ArrayList<Kaarten>();

	public Memory() {


	}
	
	/**Maakt een nieuw spel en vult de ArrayList kaarten met kaartsoort en een random uniek nummer voor elke kaart welke afhankelijk is van de moeilijkheid.
	 * 
	 * @param kaartsoort
	 * @param moeilijkheid
	 */
	public void nieuwSpel(String kaartsoort, int moeilijkheid){
		kaarten.clear();
		this.moeilijkheid = moeilijkheid;
		ArrayList<Integer> rnummers = randomNummers(moeilijkheid);
		for(int i =1; i <=moeilijkheid; i++){
			int randomTijdelijk = rnummers.get(i -1);
			kaarten.add(new Kaarten(kaartsoort, randomTijdelijk));
		}
		
		Kaarten[][] memoryVeld = new Kaarten[4][4];
		
	}
	
	

	public void setMoeilijkheid(int moeilijkheid) {
		this.moeilijkheid = moeilijkheid;
	}
	
	
	/**Maakt een Arraylist met random unieke nummers tussen 1 en en moeilijkheid van lengte moeilijkheid.
	 * 
	 * @author Koen
	 * @param moeilijkheid
	 * @return een Arraylist gevult met unieke random nummers.
	 */
	public ArrayList<Integer> randomNummers(int moeilijkheid){
		ArrayList<Integer> nummers = new ArrayList<Integer>();
		Random random = new Random();
		while(nummers.size() < moeilijkheid){
			int hulp = 1 + random.nextInt(moeilijkheid-1);
			if(!nummers.contains(hulp)){
				nummers.add(hulp);
			}
		}
		
		return nummers;
	}
	
	

}
