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
	
	public void kontadoreaErreseteatu() {
		this.kont = 0;
		this.kontadoreaEguneratu();
	}
	
	public void kontadoreaGehitu() {
		this.kont++;
		this.kontadoreaEguneratu();
	}
	
	public void kontadoreaKendu(){
		this.kont--;
		this.kontadoreaEguneratu();
	}
	
	public void zenbakiaJarri(int pZenbakia){
		this.kont = pZenbakia;
		this.kontadoreaEguneratu();
	}
	
	private void kontadoreaEguneratu(){
		int ehunekoa = this.kont/100;
		int hamarrekoa = this.kont/10;
		int batekoa = this.kont % 10;
		kontadorea[0].setIcon(Helbideak.kontadorea[ehunekoa]);
		kontadorea[1].setIcon(Helbideak.kontadorea[hamarrekoa]);
		kontadorea[2].setIcon(Helbideak.kontadorea[batekoa]);
	}

	public int getKont() {
		return this.kont;
	}
}
