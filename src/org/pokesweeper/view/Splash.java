package org.pokesweeper.view;


import javax.swing.*;
import org.pokesweeper.model.Helbideak;
import java.awt.*;

public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	private int iraupena;
	
	public Splash(int pIraupena){
		this.iraupena = pIraupena;
		JPanel panel = (JPanel) getContentPane();
		
		ImageIcon img = Helbideak.splash;
		
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
