package org.pokesweeper.controller;

public class Kontrolatzailea {
	//Atributuak
	private static Kontrolatzailea helbidea;
	
	private Kontrolatzailea(){
		
	}
	
	public static Kontrolatzailea getNireKontrolatzailea(){
		if (helbidea == null){
			helbidea = new Kontrolatzailea();
		}
		return helbidea;
	}
	
	public void mouseClicked(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb){
		
	}

	public void mouseEntered(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
		
	}

	public void mouseExited(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
		
	}

	public void mousePressed(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
		
	}

	public void mouseReleased(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
		
	}

}
