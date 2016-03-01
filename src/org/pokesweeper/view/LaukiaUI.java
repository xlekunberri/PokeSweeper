package org.pokesweeper.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import org.pokesweeper.controller.Kontrolatzailea;

public class LaukiaUI extends JButton implements MouseListener {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private int egoera;
		// 0 = Normal
		// 1 = Bandera
		// 2 = Galdera ikurra
		// 3 = Lurra
	private int zabalera;
	private int altuera;
	private int ikonoZenb;
	private Kontrolatzailea kontrolatzailea = Kontrolatzailea.getNireKontrolatzailea();
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		kontrolatzailea.mouseClicked(this.zabalera, this.altuera, this.egoera, this.ikonoZenb);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		kontrolatzailea.mouseEntered(this.zabalera, this.altuera, this.egoera, this.ikonoZenb);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		kontrolatzailea.mouseExited(this.zabalera, this.altuera, this.egoera, this.ikonoZenb);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		kontrolatzailea.mousePressed(this.zabalera, this.altuera, this.egoera, this.ikonoZenb);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		kontrolatzailea.mouseReleased(this.zabalera, this.altuera, this.egoera, this.ikonoZenb);
		
	}
	
	public void setEgoera(int pEgoera){
		this.egoera = pEgoera;
	}

}
