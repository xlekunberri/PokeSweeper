package org.pokesweeper.view;

import org.pokesweeper.model.Audio;

import javax.swing.*;
import org.pokesweeper.model.Helbideak;
import java.awt.*;

public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	private int iraupena;
	
	public Splash(int pIraupena){
		this.iraupena = pIraupena;
		JPanel panel = (JPanel) getContentPane();
		this.setBackground(new Color(0, 0, 0, 0));
		
		ImageIcon img = Helbideak.splashGif;
		
		panel.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);
		Audio audio = Audio.getNireAudio();
		
		try{
			audio.playAudio(Helbideak.splashSound);
			Thread.sleep(iraupena);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		setVisible(false);
		
	}


}
