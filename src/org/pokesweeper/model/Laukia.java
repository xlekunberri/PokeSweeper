package org.pokesweeper.model;

import javax.swing.ImageIcon;
import org.pokesweeper.view.PikaUI;
import org.pokesweeper.view.TableroaUI;

public class Laukia {
	
	private TableroaUI tableroa = TableroaUI.getNireTableroaUI(1,1);
	
	public void mouseClicked(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb){
		if (pEgoera != 3){
			tableroa.laukiak[pZabalera][pAltuera].setEgoera(3);
			tableroa.laukiak[pZabalera][pAltuera].setRolloverIcon(null);
			tableroa.laukiak[pZabalera][pAltuera].repaint();
		}
	}

	public void mouseEntered(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
    	if(pEgoera != 3) {
    		PikaUI.getNirePika().setPikaEgoera("click");
    	}
	}
	
	public void mouseReleased(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
    	PikaUI.getNirePika().setPikaEgoera("normal");
	}

	//SI HAY PROBLEMAS ES PROBABLE QUE SEAN EN ESTOS METODOS, AL CARGAR LOS ICONOS
	public void mousePressed(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
    	if(pEgoera != 3) {
    		String helbidea = "Helbideak.belar_mugimendu_" + pIkonoZenb;
    		tableroa.laukiak[pZabalera][pAltuera].setRolloverIcon(new ImageIcon(helbidea));
    		tableroa.laukiak[pZabalera][pAltuera].repaint();
    	}
	}
	
	public void mouseExited(int pZabalera, int pAltuera, int pEgoera, int pIkonoZenb) {
		if(pEgoera != 3) {
			String helbidea = "Helbideak.belar_normal_" + pIkonoZenb;
			tableroa.laukiak[pZabalera][pAltuera].setIcon(new ImageIcon(helbidea));
			tableroa.laukiak[pZabalera][pAltuera].repaint();
    	}
	}



}
