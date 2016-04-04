package org.pokesweeper.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.pokesweeper.model.Helbideak;

public class KontadoreaUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton[] kontadorea = new JButton[3];

	public KontadoreaUI() {
		this.setBackground(new Color(112, 200, 160));
		GridLayout grid = new GridLayout(1, 3, 0, 0);
		this.setLayout(grid);
		for(int i = 0; i < kontadorea.length; i++){
			kontadorea[i] = new JButton(Helbideak.kontadorea[0]);
			kontadorea[i].setBorder(null);
			kontadorea[i].setContentAreaFilled(false);
			this.add(kontadorea[i]);
		}
	}
	
	public void kontadoreaEguneratu(int pEhunekoa, int pHamarrekoa, int pBatekoa){
		kontadorea[0].setIcon(Helbideak.kontadorea[pEhunekoa]);
		kontadorea[1].setIcon(Helbideak.kontadorea[pHamarrekoa]);
		kontadorea[2].setIcon(Helbideak.kontadorea[pBatekoa]);
	}
	


}
