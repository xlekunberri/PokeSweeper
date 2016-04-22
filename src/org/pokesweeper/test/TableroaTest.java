package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.Tableroa;
import org.pokesweeper.view.JokoaUI;

public class TableroaTest {
	
	Tableroa nireTableroa;
	JokoaUI nireJokoaUI;

	@Before
	public void setUp() throws Exception {
		nireTableroa = Tableroa.getNireTableroa();
		nireJokoaUI = JokoaUI.getNireJokoa();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTableroaEraiki() {
		nireTableroa.tableroaEraiki(7, 10, 7, false);
		assertTrue(nireTableroa.laukiFalta == 70);
	}
	
	@Test
	public void testGetZutabeKop() {
		nireTableroa.tableroaEraiki(7, 10, 7, false);
		assertTrue(Tableroa.getNireTableroa().getErrenkadaKop() == 7);
		
		nireTableroa.tableroaEraiki(1, 10, 7, false);
		assertFalse(Tableroa.getNireTableroa().getErrenkadaKop() == 7);
		assertTrue(Tableroa.getNireTableroa().getErrenkadaKop() == 1);
	}
	
	
	@Test
	public void testGetErrenkadaKop() {
		nireTableroa.tableroaEraiki(7, 10, 7, false);
		assertTrue(Tableroa.getNireTableroa().getZutabeKop() == 10);
		
		nireTableroa.tableroaEraiki(7, 1, 7, false);
		assertFalse(Tableroa.getNireTableroa().getZutabeKop() == 10);
		assertTrue(Tableroa.getNireTableroa().getZutabeKop() == 1);
	}
	
	@Test
	public void testGetMinaKop() {
		nireTableroa.tableroaEraiki(7, 10, 7, false);
		assertTrue(Tableroa.getNireTableroa().getMinaKop() == 7);
		
		nireTableroa.tableroaEraiki(7, 10, 0, false);
		assertFalse(Tableroa.getNireTableroa().getMinaKop() == 7);
		assertTrue(Tableroa.getNireTableroa().getMinaKop() == 0);
	}
	
	@Test
	public void testMinakBistaratu() {
		nireTableroa.minakBistaratu();
		assertTrue(JokoaUI.bukatuta);
	}

}
