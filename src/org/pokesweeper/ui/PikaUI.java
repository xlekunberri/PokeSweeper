package org.pokesweeper.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PikaUI extends JButton implements ActionListener{
	
	private static PikaUI nirePika;

	private PikaUI() {
		try {
			Image img = ImageIO.read(getClass().getResource(Helbideak.pikaNormal));
			this.setIcon(new ImageIcon(img));
		} catch (IOException e) {}
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
		String helbidea;
		if(pEgoera.equals("normal")) {
			helbidea = Helbideak.pikaNormal;
		}
		else if(pEgoera.equals("irabazi")) {
			helbidea = Helbideak.pikaIrabazi;
		}
		else if(pEgoera.equals("galdu")) {
			helbidea = Helbideak.pikaGaldu;
		}
		else {
			helbidea = Helbideak.pikaKlik;
		}
		
		try {
			Image img = ImageIO.read(getClass().getResource(helbidea));
			this.setIcon(new ImageIcon(img));
		} catch (IOException e) {}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
