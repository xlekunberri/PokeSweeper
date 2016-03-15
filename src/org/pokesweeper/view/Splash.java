package org.pokesweeper.view;

import javax.swing.*;

import org.pokesweeper.model.Helbideak;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	
	public Splash(){
		this.setBackground(new Color(0, 0, 0, 0));
		
		ImageIcon img = Helbideak.splashGif;
		this.setFocusable(true);
		this.setFocusableWindowState(true);
		this.requestFocusInWindow();
		this.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
		this.getContentPane().addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				System.out.println("adlvhsekugheso");
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

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
