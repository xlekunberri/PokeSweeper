package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javafx.scene.media.MediaPlayer.Status;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.pokesweeper.model.Audioa;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.PokeSweeper;

public class Splash extends JPanel {
	
	//Atributoak
	private static final long serialVersionUID = 1L;

	//Eraikitzailea
	public Splash(){
		this.setLayout(new BorderLayout());
		final Audioa audio = new Audioa(Helbideak.splashSound);
		audio.play();
		JLabel label = new JLabel(Helbideak.splashGif);
		this.add(label,BorderLayout.CENTER);
		label.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (audio.getPlayer().getStatus()==Status.STOPPED){
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						PokéSweeperUI.getNirePokéSweeperUI().dispose();
						PokéSweeperUI.getNirePokéSweeperUI().setUndecorated(false);
						PokeSweeper.getNirePokéSweeper().hurrengoa(1);
					}
				}
			}
		});
		PokéSweeperUI.getNirePokéSweeperUI().panelaAldatu(this);
		label.setFocusable(true);
		audio.getPlayer().setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				audio.getPlayer().stop();
			}
		});
		
	}
}
