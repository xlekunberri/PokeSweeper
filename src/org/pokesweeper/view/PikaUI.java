package org.pokesweeper.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Tableroa;

public class PikaUI extends JButton{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private static PikaUI nirePika;

	//Eraikitzailea
	private PikaUI() {
		this.setIcon(Helbideak.pikaNormal);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e) {
		    	Tableroa tableroa = Tableroa.getNireTableroa();
		    	if(e.getButton() == MouseEvent.BUTTON1){
			    	JokoaUI.getNireJokoa().erreseteatu(tableroa.getErrenkadaKop(), tableroa.getZutabeKop(), tableroa.getMinaKop(), false);
		    	} 
		    	else if(e.getButton() == MouseEvent.BUTTON3){
					JokoaUI.getNireJokoa().erreseteatu(tableroa.getErrenkadaKop(), tableroa.getZutabeKop(), tableroa.getMinaKop(), true);
			    }
		    	JokoaUI.denboraKontadorea.denboraErreseteatu();
		    	PikaUI.getNirePika().setPikaEgoera("normal");
		    }
		});
	}
	
	public static PikaUI getNirePika() {
		if (nirePika == null) {
			nirePika = new PikaUI();
		}
		return nirePika;
	}
	
	//Beste metodoak
	public void setPikaEgoera(String pEgoera) {
		switch (pEgoera) {
		case "normal":
			this.setIcon(Helbideak.pikaNormal);
			break;
		case "irabazi":
			this.setIcon(Helbideak.pikaIrabazi);
			break;
		case "galdu":
			this.setIcon(Helbideak.pikaGaldu);
			break;
		case "klik":
			this.setIcon(Helbideak.pikaKlik);
			break;
		}
		this.repaint();
	}

}
