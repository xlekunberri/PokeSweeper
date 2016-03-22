package org.pokesweeper.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.pokesweeper.model.Helbideak;

public abstract class Kontadorea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected int kont = 0;
	private JButton[] kontadorea = new JButton[3];

	public Kontadorea() {
		this.setBackground(new Color(112, 200, 160));
		//this.setPreferredSize(new Dimension(39, 23));
		GridLayout grid = new GridLayout(1, 3, 0, 0);
		this.setLayout(grid);
		
		kontadoreaEraiki();
	}
	
	private void kontadoreaEraiki() {
		for(int i = 0; i < kontadorea.length; i++) {
			kontadorea[i] = new JButton(Helbideak.kontadorea[0]);
			kontadorea[i].setBorder(null);
			kontadorea[i].setContentAreaFilled(false);
			this.add(kontadorea[i]);
		}
	}
	
	protected void kontadoreaEguneratu(){
		int ehunekoa = this.kont/100;
		int hamarrekoa = (this.kont%100)/10;
		int batekoa = (this.kont%100) % 10;
		kontadorea[0].setIcon(Helbideak.kontadorea[ehunekoa]);
		kontadorea[1].setIcon(Helbideak.kontadorea[hamarrekoa]);
		kontadorea[2].setIcon(Helbideak.kontadorea[batekoa]);
		if (kont==999){
			JokoaUI.galdu();
		}
	}

	public int getKont() {
		return this.kont;
	}

}
