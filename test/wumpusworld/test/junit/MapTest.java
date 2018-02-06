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

}
