package org.pokesweeper.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;

import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Pika;

public class PikaUI extends JButton{
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	private static PikaUI nirePika;

	//Eraikitzailea
	public static PikaUI getNirePika() {
		if (nirePika == null) {
			nirePika = new PikaUI();
		}
		return nirePika;
	}
	
	private PikaUI() {
		this.setIcon(Helbideak.pikaNormal);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		    	if(e.getButton() == MouseEvent.BUTTON1){
		    		Pika.getNirePika().ezkerrekoKlik();
		    	} 
		    	else if(e.getButton() == MouseEvent.BUTTON3){
					Pika.getNirePika().eskumakoKlik();
			    }
		    }
		});
	}
	
	//Beste metodoak
	public void setPikaEgoera(Icon pIkonoa) {
		this.setIcon(pIkonoa);
		this.repaint();
	}

}
