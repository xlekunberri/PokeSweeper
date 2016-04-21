package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.BichilloLaukia;
import org.pokesweeper.model.Helbideak;
import org.pokesweeper.view.JokoaUI;

public class BichilloLaukiaTest {
	BichilloLaukia laukia00, laukia01, laukia10, laukia11;
	JokoaUI jokoa;

	@Before
	public void setUp() throws Exception {
		laukia00 = new BichilloLaukia(0,0,1);
		laukia01 = new BichilloLaukia(0,1,1);
		laukia10 = new BichilloLaukia(1,0,1);
		laukia11 = new BichilloLaukia(1,1,1);
		jokoa = JokoaUI.getNireJokoa();
		Helbideak.denakKargatu();
	}

	@After
	public void tearDown() throws Exception {
		laukia00 = null;
		laukia01 = null;
		laukia10 = null;
		laukia11 = null;
		jokoa = null;
	}

	@Test
	public void testEzkerrekoBotoia() {
		assertTrue(laukia00.getIkonoa() == laukia01.getIkonoa());
		laukia00.setEgoera(3);
		laukia00.ezkerrekoBotoia();
		laukia01.ezkerrekoBotoia();
		assertFalse(laukia00.getIkonoa() == laukia01.getIkonoa());
	}

}
