package org.pokesweeper.view;


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class Splash extends JWindow {
	
	
	private int iraupena = 0;
	
	public Splash(int pIraupena){
		this.iraupena = pIraupena;
		
		JPanel panel = (JPanel) getContentPane();
		ImageIcon img=null;
		try{
		img = new ImageIcon(ImageIO.read(this.getClass().getResource("intro.png")));
		}catch (IOException e){
			 e.printStackTrace();
		}
		
		panel.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		
		try{
			Thread.sleep(iraupena);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		setVisible(false);
		
	}


}
