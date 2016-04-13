package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.pokesweeper.model.Audioa;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.PokéSweeper;

public class Splash extends JPanel {
	
	//Atributoak
	private static final long serialVersionUID = 1L;

	//Eraikitzailea
	public Splash(){
		final Audioa audio = new Audioa(Helbideak.splashSound);
		audio.play();
		JLabel label = new JLabel(Helbideak.splashGif);
		this.add(label,BorderLayout.CENTER);
		label.setFocusable(true);
		label.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					PokéSweeper.getNirePokéSweeper().hurrengoa(1);
				}
			}
		});
		PokéSweeperUI.getNirePokéSweeperUI().panelaAldatu(this);
		PokéSweeperUI.getNirePokéSweeperUI().setLocationRelativeTo(null);
	}
}
