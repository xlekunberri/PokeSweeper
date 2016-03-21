package org.pokesweeper.view;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import org.pokesweeper.model.BarruLaukia;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Tableroa;

public class LaukiaUI extends JButton implements MouseListener {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private final int errenkada;
	private final int zutabe;
	
	//Eraikitzailea
	public LaukiaUI(int pErrenkada, int pZutabe){
		this.errenkada = pErrenkada;
		this.zutabe = pZutabe;
		BarruLaukia laukiLogikoa = Tableroa.getNireTableroa().laukia[pErrenkada][pZutabe];
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
        this.addMouseListener(this);
        this.setIcon(Helbideak.belar_normal[laukiLogikoa.getIkonoZenb()]);
        this.repaint();
	}

	//Beste metodoak
	@Override
	public void mouseClicked(MouseEvent e) {
		//Ezkerra = true
		//Eskuma = false
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseClicked(true);	
    	} 
    	else if(e.getButton() == MouseEvent.BUTTON3){
    		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseClicked(false);	
    	}
	
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
		if(e.getButton() == MouseEvent.BUTTON1){
			Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mousePressed();	
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tableroa.getNireTableroa().laukia[this.errenkada][this.zutabe].mouseReleased();	
	}

}
