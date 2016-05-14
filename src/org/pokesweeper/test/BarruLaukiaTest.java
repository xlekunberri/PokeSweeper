package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.BarruLaukia;
import org.pokesweeper.model.Tableroa;
import org.pokesweeper.view.JokoaUI;

public class BarruLaukiaTest {
	Tableroa tab;
	JokoaUI j;

	@Before
	public void setUp() throws Exception {
		tab = Tableroa.getNireTableroa();
		j = JokoaUI.getNireJokoa();
	}

	@After
	public void tearDown() throws Exception {
		tab=null;
		j=null;
	}

	@Test
	public void testKoordenadaEgokiak() {
		tab.tableroaEraiki(5, 5, 5, false);
		BarruLaukia b = new BarruLaukia(6, 3);
		assertFalse(b.jKoordenadaEgokiak(6, 3));
		BarruLaukia b1 = new BarruLaukia(3, 3);
		assertTrue(b1.jKoordenadaEgokiak(3, 3));
		BarruLaukia b2 = new BarruLaukia(-1, 3);
		assertFalse(b2.jKoordenadaEgokiak(-1, 3));
		BarruLaukia b3 = new BarruLaukia(3, -1);
		assertFalse(b3.jKoordenadaEgokiak(3, -1));
		BarruLaukia b4 = new BarruLaukia(3, 6);
		assertFalse(b4.jKoordenadaEgokiak(3, 6));
	}

}

