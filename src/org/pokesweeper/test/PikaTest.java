package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.model.Pika;
import org.pokesweeper.model.Tableroa;
import org.pokesweeper.view.JokoaUI;

public class PikaTest {
	
	@Before
	public void setUp() throws Exception {
		Pika.getNirePika();
		Tableroa.getNireTableroa();
		JokoaUI.getNireJokoa();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPikaEgoera() {
		Pika pika = Pika.getNirePika();
		pika.setPikaEgoera("normal");
		assertTrue(pika.getIkonoa() == Helbideak.pikaNormal);
		pika.setPikaEgoera("irabazi");
		assertTrue(pika.getIkonoa() == Helbideak.pikaIrabazi);
		pika.setPikaEgoera("galdu");
		assertTrue(pika.getIkonoa() == Helbideak.pikaGaldu);
		pika.setPikaEgoera("klik");
		assertTrue(pika.getIkonoa() == Helbideak.pikaKlik);
	}
	
	@Test
	public void testEskumakoKlik(){
		Pika pika = Pika.getNirePika();
		pika.eskumakoKlik();
		assertTrue(pika.getIkonoa() == Helbideak.pikaNormal);
	}
	
	@Test
	public void testEskerrekoKlik(){
		Pika pika = Pika.getNirePika();
		Tableroa tableroa = Tableroa.getNireTableroa();
		JokoaUI jokoaUI = JokoaUI.getNireJokoa();
		
		pika.setPikaEgoera("galdu");
		tableroa.setMinaKop(0);
		pika.ezkerrekoKlik();
		assertTrue(pika.getIkonoa() == Helbideak.pikaGaldu);
		
		tableroa.setMinaKop(1);
		jokoaUI.setMaila(1);
		pika.ezkerrekoKlik();
		assertTrue(pika.getIkonoa() == Helbideak.pikaNormal);
	}

}
