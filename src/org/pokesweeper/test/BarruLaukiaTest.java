package org.pokesweeper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pokesweeper.model.BarruLaukia;
import org.pokesweeper.model.LaukiFactory;
import org.pokesweeper.model.LurLaukia;
import org.pokesweeper.model.Tableroa;

public class BarruLaukiaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKoordenadaEgokiak() {
		Tableroa tab = Tableroa.getNireTableroa();
		tab.tableroaEraiki(5, 5, 5, false);
		BarruLaukia b = LaukiFactory.getNireFactory().createLaukia(6, 5, false);
		b.koordenadaEgokiak(pErrenkada, pZutabe)
		
	}

}
