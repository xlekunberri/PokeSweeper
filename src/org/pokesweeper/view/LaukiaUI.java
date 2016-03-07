package org.pokesweeper.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import org.pokesweeper.model.Tableroa;

public class LaukiaUI extends JButton implements MouseListener {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final int errenkada;
	private final int zutabe;
	
	//Eraikitzailea
	public LaukiaUI(int pErrenkada, int pZutabe) {
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
	}
	
	//Beste metodoak
	@Override
	public void mouseClicked(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseClicked();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseEntered();		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseExited();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mousePressed();	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseReleased();	
	}

}
