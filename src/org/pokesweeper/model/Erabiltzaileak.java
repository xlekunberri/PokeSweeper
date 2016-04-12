package org.pokesweeper.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Erabiltzaileak {
	
	File fitxErabiltzaileak;
	private static Erabiltzaileak nireErabiltzaileak;
	
	private Erabiltzaileak(){
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		if (!fitxErabiltzaileak.exists()){
			try {
				fitxErabiltzaileak.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public static Erabiltzaileak getNireErabiltzaileak(){ 
		 
	    	if (nireErabiltzaileak == null) {
				nireErabiltzaileak = new Erabiltzaileak();
			}
			return nireErabiltzaileak;
	    }
	
	public void idatzi(String user, String pass) throws IOException{
		
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		try{
			if (!baDago(user)){
				FileWriter fw=new FileWriter(fitxErabiltzaileak, true);
				BufferedWriter output=new BufferedWriter(fw);
				output.write(user + " ### " + pass);
				output.newLine();
				output.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private boolean logeatu(String user, String pass) { //if true actualiza
		fitxErabiltzaileak=new File("ranking.txt");
		boolean dago=false;
		try{
			 Scanner sarrera = new Scanner(new FileReader(fitxErabiltzaileak));
			 String lerroa;
			 while (sarrera.hasNext() && !dago) {
				 lerroa = sarrera.nextLine();
				 String[] hitzak=lerroa.split(" ### ");
				 if (hitzak[0].equals(user) && hitzak[1].equals(pass)){
					 dago = true;
				 }
			 }
			 sarrera.close();
			 }
		catch(IOException e){
			 e.printStackTrace();
		}
		return dago;
	}
	
	private boolean baDago(String user) { //if true actualiza
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		boolean dago=false;
		try{
			 Scanner sarrera = new Scanner(new FileReader(fitxErabiltzaileak));
			 String lerroa;
			 while (sarrera.hasNext() && !dago) {
				 lerroa = sarrera.nextLine();
				 String[] hitzak=lerroa.split(" ### ");
				 if (hitzak[0].equals(user)){
					 dago = true;
				 }
			 }
			 sarrera.close();
			 }
		catch(IOException e){
			 e.printStackTrace();
		}
		return dago;
	}
	
	
	private void erabiltzaileaSortu(String user, String pass) {
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		try{
			 if (!baDago(user)){
				FileWriter fw=new FileWriter(fitxErabiltzaileak, true);
				BufferedWriter output=new BufferedWriter(fw);
				output.write(user + " ### " + pass);
				output.newLine();
				output.close();

				 }
			 }
		catch(IOException e){
			 e.printStackTrace();
		}
	}


}
