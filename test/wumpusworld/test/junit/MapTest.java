package wumpusworld.test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import wumpusworld.Map;

public class MapTest {

	@Test
	public void testInitialMapDimensions() {
		Map worldMap = new Map(2, 2);
		assertEquals(2, worldMap.getWidth());
		assertEquals(2, worldMap.getHeight());
		worldMap = new Map(3,3);
		assertEquals(3, worldMap.getWidth());
		assertEquals(3, worldMap.getHeight());
	}
	
	@Test
	public void testCaverns() {
		Map worldMap = new Map(2, 2);
		worldMap.addCavern(0,0);
		assertTrue(worldMap.isCavern(0,0));
		assertFalse(worldMap.isCavern(1,0));
		assertFalse(worldMap.isCavern(0,1));
		assertFalse(worldMap.isCavern(1,1));
	}

}
