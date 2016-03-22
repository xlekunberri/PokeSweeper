package org.pokesweeper.model;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Helbideak {

	public static Font iturria;
	public static Font unownIturria;
	public static Image ikonoa;
	public static Cursor kursorea;
	
	public static Icon pikaNormal;
	public static Icon pikaIrabazi;
	public static Icon pikaGaldu;
	public static Icon pikaKlik;
	
	public static Icon voltorb;
	public static Icon voltorb_s;
	
	public static Icon[] lurra = new Icon[9];
	public static Icon[] belar_normal = new Icon[16];
	public static Icon[] belar_mugimendu = new Icon[9];
	public static Icon[] zenbaki = new Icon[8];
	
	public static Icon[] kontadorea = new Icon[12];
	public static ImageIcon lorea;
	
	public static Icon[] bichilloak = new Icon[41];
	
	public static ImageIcon splash;
	public static ImageIcon splashGif;
	
	public static ImageIcon[] bandera = new ImageIcon[9];
	public static Icon galdera;
	
	public static void denakKargatu(){
		Helbideak.besteakKargatu();
		Helbideak.lurraKargatu();
		Helbideak.belarraKargatu();
		Helbideak.mugimenduaKargatu();
		Helbideak.pikaKargatu();
		Helbideak.zenbakiakKargatu();
		Helbideak.bichilloakKargatu();
		Helbideak.kontadoreaKargatu();
		Helbideak.banderaKargatu();
	}
	
	private static void besteakKargatu(){
		try{
			iturria = (Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("skin/font/normala.ttf"))).deriveFont(12F);
			unownIturria = (Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("skin/font/unown.ttf"))).deriveFont(12F);
			ikonoa = ImageIO.read(new File("skin/ikonoa.png"));
		}catch (IOException | FontFormatException e){}
		kursorea = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("skin/kursorea.png") , new Point(3, 30), "img");
		voltorb = new ImageIcon("skin/laukiak/voltorb/voltorb.png");
		voltorb_s = new ImageIcon("skin/laukiak/voltorb/voltorb_s.png");
		splash = new ImageIcon("skin/splash.png");
		splashGif = new ImageIcon("skin/splash.gif");
		galdera = new ImageIcon("skin/laukiak/galdera.png");
		lorea = new ImageIcon("skin/kontadorea/lorea.gif");
	}
		
	private static void pikaKargatu(){
		pikaNormal = new ImageIcon("skin/pika/normal.png");
		pikaIrabazi = new ImageIcon("skin/pika/irabazi.png");
		pikaGaldu = new ImageIcon("skin/pika/galdu.png");
		pikaKlik = new ImageIcon("skin/pika/klik.png");
	}
	
	private static void lurraKargatu() {
		for(int i = 0; i < lurra.length; i++)
			lurra[i] = new ImageIcon("skin/laukiak/lurra/"+(i+1)+".png");
	}
	
	private static void belarraKargatu() {
		for(int i = 0; i < belar_normal.length; i++)
			belar_normal[i] = new ImageIcon("skin/laukiak/belarra/normala/"+(i+1)+".png");
	}
	
	private static void mugimenduaKargatu() {
		for(int i = 0; i < belar_mugimendu.length; i++)
			belar_mugimendu[i] = new ImageIcon("skin/laukiak/belarra/mugimendua/5.gif");
	}
	
	private static void banderaKargatu() {
		for(int i = 0; i < bandera.length; i++)
			bandera[i] = new ImageIcon("skin/laukiak/bandera/"+(i+1)+".gif");
	}
	
	private static void zenbakiakKargatu() {
		for(int i = 0; i < zenbaki.length; i++)
			zenbaki[i] = new ImageIcon("skin/laukiak/zenbakiak/"+(i+1)+".png");
	}
	
	private static void bichilloakKargatu() {
		for(int i = 0; i < bichilloak.length; i++)
				bichilloak[i] = new ImageIcon("skin/laukiak/bichilloak/image"+(i+1)+".png");
	}
	
	private static void kontadoreaKargatu() {
			for(int i = 0; i < kontadorea.length; i++)
				kontadorea[i] = new ImageIcon("skin/kontadorea/"+i+".png");
			//	kontadorea[i] = new ImageIcon("skin/kontadorea/besteak/"+i+".png");
	}
	
}
