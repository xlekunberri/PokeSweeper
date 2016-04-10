package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.pokesweeper.model.Audioa;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Ranking;

import javafx.embed.swing.JFXPanel;


public class Splash extends JFrame {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	final JFXPanel jfx;
	//Eraikitzailea
	public Splash(){
		
		jfx = new JFXPanel();
		
		final Audioa audio = new Audioa(Helbideak.splashSound);
		audio.play();
		
		setUndecorated(true);
		
		JLabel label = new JLabel(Helbideak.splashGif);
		this.add(label,BorderLayout.CENTER);
		label.setFocusable(true);

		label.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setVisible(false);
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								audio.stop();
								JokoaUI frame = JokoaUI.getNireJokoa();
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
								Ranking.getNireRanking();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		
		pack();
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
	}
}
