package org.pokesweeper.model;

import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URI;

import javafx.scene.media.Media;

public class Audioa{
	
	//Atributoak
	private static Media md;
	private static MediaPlayer player;
	
	//Eraikitzailea
	public Audioa(File pAudio){
		URI kanta = pAudio.toURI();
		md = new Media(kanta.toString());
		player = new MediaPlayer(md);
		player.setVolume(0.1);
	}
	
	//Beste metodoak
	public void play(){
		try{
			player.play();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void setVolume(double z){
		player.setVolume(z/100);
	}
	
	public void stop(){
		try{
			player.stop();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public MediaPlayer getPlayer(){
		return player;
	}
}