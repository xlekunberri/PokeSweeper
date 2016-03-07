package org.pokesweeper.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.pokesweeper.model.Helbideak;

public class Kontadorea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int kont = -1;
	private JButton[] kontadorea = new JButton[3];

	public Kontadorea() {
		this.setBackground(new Color(112, 200, 160));
		this.setPreferredSize(new Dimension(39, 23));
		
		GridLayout grid = new GridLayout(1, 3, 0, 0);
		this.setLayout(grid);
		
		kontadoreaEraiki();
	}
	
	private void kontadoreaEraiki() {
		for(int i = 0; i < kontadorea.length; i++) {
			kontadorea[i] = new JButton();
			kontadorea[i].setBorder(BorderFactory.createEmptyBorder());
			kontadorea[i].setContentAreaFilled(false);
			kontadorea[i].setBorderPainted(false);
			kontadorea[i].setMargin(new Insets(0, 0, 0, 0));
			kontadorea[i].setPreferredSize(new Dimension(13, 23));
			kontadorea[i].setIcon(Helbideak.kontadorea[0]);
			this.add(kontadorea[i]);
		}
	}
	
	public void kontadoreaGehitu() {
		this.kont++;
	}
	
	public void kontadoreaErreseteatu() {
		this.kont = -1;
	}
}
