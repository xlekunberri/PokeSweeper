package org.pokesweeper.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import org.pokesweeper.model.Helbideak;

public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	
	public Splash(){
		this.setBackground(new Color(0, 0, 0, 0));
		
		ImageIcon img = Helbideak.splashGif;
		this.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				setVisible(false);
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JokoaUI frame = JokoaUI.getNireJokoa();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
	}

}
