package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.pokesweeper.model.Helbideak;

public class Splash extends JFrame {
	
	//Atributoak
	private static final long serialVersionUID = 1L;
	
	//Eraikitzailea
	public Splash(){
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
