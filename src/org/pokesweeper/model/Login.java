package org.pokesweeper.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	
	File fitxErabiltzaileak;
	private static Login nireErabiltzaileak;
	
	private Login(){
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		if (!fitxErabiltzaileak.exists()){
			try {
				fitxErabiltzaileak.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public static Login getNireLogin(){ 
		 
	    	if (nireErabiltzaileak == null) {
				nireErabiltzaileak = new Login();
			}
			return nireErabiltzaileak;
	    }

	public boolean logeatu(String user, String pass) {
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
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
	
	
	public boolean erabiltzaileaSortu(String user, String pass) {
		fitxErabiltzaileak=new File("erabiltzaileak.txt");
		boolean sortuta = false;
		try{
			if (!baDago(user)){
				FileWriter fw=new FileWriter(fitxErabiltzaileak, true);
				BufferedWriter output=new BufferedWriter(fw);
				output.write(user + " ### " + pass);
				output.newLine();
				output.close();
				sortuta=true;
	
			}
		}
		catch(IOException e){
			 e.printStackTrace();
		}
		return sortuta;
	}


}
