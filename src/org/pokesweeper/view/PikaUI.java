package org.pokesweeper.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.pokesweeper.model.Helbideak;

public class PikaUI extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static PikaUI nirePika;

	private PikaUI() {
		this.setIcon(Helbideak.pikaNormal);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
	}
	
	public static PikaUI getNirePika() {
		if (nirePika == null) {
			nirePika = new PikaUI();
		}
		return nirePika;
	}
	
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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
