package org.pokesweeper.model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Soinua {

	private Clip soinua;
	
	public Soinua()
	{
		try 
		{			
			//coge el audio del sistema			
			soinua=AudioSystem.getClip();					
		} 
		catch (LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Reproducir los sonidos que quiera para mi programa
	public void musicaFondo()
	{
		try {
			soinua.open(AudioSystem.getAudioInputStream(new File("ruta")));
			//sonido.start();
			//loop_continiusly es para que se repita
			soinua.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
