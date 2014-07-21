package memory;

import java.util.ArrayList;

public class Kaarten {
	
	
	/**
	 * De klasse om de kaart-type te beheren.
	 * 
	 * Oke dan
	 * @author Koen
	 */

	private int aantal = 8;
	private String kaartsoort = "pony";

	public Kaarten (){
		
	}

	public void setKaartSet(String kaartsoort) {
		this.kaartsoort = kaartsoort;
	}
	
	public String getKaartSet(){
		return kaartsoort;
	}

}
