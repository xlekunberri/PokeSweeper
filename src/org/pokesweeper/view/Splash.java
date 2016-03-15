package org.pokesweeper.view;

import javax.swing.*;

import org.pokesweeper.model.Helbideak;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		this.getContentPane().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
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
		});
		
	}

}
