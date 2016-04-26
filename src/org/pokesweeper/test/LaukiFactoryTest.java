package org.pokesweeper.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.pokesweeper.model.BarruLaukia;
import org.pokesweeper.model.LaukiFactory;
import org.pokesweeper.model.LurLaukia;
import org.pokesweeper.model.MinaLaukia;
import org.pokesweeper.view.JokoaUI;

public class LaukiFactoryTest {
	
	BarruLaukia test1;
	BarruLaukia test2;
	BarruLaukia test3;
	BarruLaukia test4;
	BarruLaukia test5;
	BarruLaukia test6;
	BarruLaukia test7;
	BarruLaukia test8;
	BarruLaukia test9;
	
	JokoaUI nireJokoaUI = JokoaUI.getNireJokoa();
	
	@Test
	public void testCreateLaukia() {
		/*
		 * Metodo honek ez du begiratzen esa parametrotzat dituen koordenatuak egokiak diren.
		 * Metodoaren deiak, beste metodo batek egiten ditu (Tableroa/tableroaEraiki())
		 * Beraz, aldez aurretik Factoryari tamaina bat ezarri beharko diogu  
		 */
		
		LaukiFactory nireFactory = LaukiFactory.getNireFactory();
		nireFactory.setTamaina(5, 5, 0);
		
		test1 = nireFactory.createLaukia(0, 0, false);
		test2 = nireFactory.createLaukia(1, 0, false);
		test3 = nireFactory.createLaukia(2, 0, false);
		test4 = nireFactory.createLaukia(3, 0, false);
		test5 = nireFactory.createLaukia(4, 0, false);
		test6 = nireFactory.createLaukia(2, 0, false);
		test7 = nireFactory.createLaukia(2, 2, false);
		test8 = nireFactory.createLaukia(2, 3, false);
		test9 = nireFactory.createLaukia(4, 4, false);
		
		assertTrue(test1 instanceof LurLaukia);
		assertTrue(test2 instanceof LurLaukia);
		assertTrue(test3 instanceof LurLaukia);
		assertTrue(test4 instanceof LurLaukia);
		assertTrue(test5 instanceof LurLaukia);
		assertTrue(test6 instanceof LurLaukia);
		assertTrue(test7 instanceof LurLaukia);
		assertTrue(test8 instanceof LurLaukia);
		assertTrue(test9 instanceof LurLaukia);
		
		nireFactory.setTamaina(5, 5, 25);
		
		test1 = nireFactory.createLaukia(0, 0, false);
		test2 = nireFactory.createLaukia(1, 0, false);
		test3 = nireFactory.createLaukia(2, 0, false);
		test4 = nireFactory.createLaukia(3, 0, false);
		test5 = nireFactory.createLaukia(4, 0, false);
		test6 = nireFactory.createLaukia(2, 0, false);
		test7 = nireFactory.createLaukia(2, 2, false);
		test8 = nireFactory.createLaukia(2, 3, false);
		test9 = nireFactory.createLaukia(4, 4, false);
		
		assertTrue(test1 instanceof MinaLaukia);
		assertTrue(test2 instanceof MinaLaukia);
		assertTrue(test3 instanceof MinaLaukia);
		assertTrue(test4 instanceof MinaLaukia);
		assertTrue(test5 instanceof MinaLaukia);
		assertTrue(test6 instanceof MinaLaukia);
		assertTrue(test7 instanceof MinaLaukia);
		assertTrue(test8 instanceof MinaLaukia);
		assertTrue(test9 instanceof MinaLaukia);
		
		/*
		 * ZenbakiLaukiak probatzeko orduan, minak ausaz ipintzen direnez, ez dakigu minak non ipiniko diren.
		 * Beraz, hauek probatzeko, bisualki egin behar izan dugu, hau da, jolasten dugun bitartean.
		 */
	}

}
