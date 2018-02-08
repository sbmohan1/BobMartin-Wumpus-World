package wumpusworld.test.junit;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import wumpusworld.Map;

public class MapTest {
	
	@Test
	public void cavernCannotBeAddedOutsideMapDimensions() {
		Map map = new Map(1, 1);
		try {
			map.addCavern(-1, 0);
			fail();
		}
		catch (ArrayIndexOutOfBoundsException ex) { }
		try {
			map.addCavern(0, -1);
			fail();
		}
		catch (ArrayIndexOutOfBoundsException ex) { }
		try {
			map.addCavern(1, 0);
			fail();
		}
		catch (ArrayIndexOutOfBoundsException ex) { }
		try {
			map.addCavern(0, 1);
			fail();
		}
		catch (ArrayIndexOutOfBoundsException ex) { }
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
	
	@Test
	public void testBats() {
		Map worldMap = new Map(2, 2);
		worldMap.addBats(0,0);
		assertTrue(worldMap.isBats(0,0));
		assertFalse(worldMap.isBats(1,0));
		assertFalse(worldMap.isBats(0,1));
		assertFalse(worldMap.isBats(1,1));
	}
	
	@Test
	public void testContainsPoint_Centre() {
		Map worldMap = new Map(3, 3);
		assertTrue(worldMap.contains(new Point(1, 1)));
	}
	
	@Test
	public void testContainsPoint_Outside() {
		Map worldMap = new Map(3, 3);
		assertFalse(worldMap.contains(new Point(-1, 1)));
		assertFalse(worldMap.contains(new Point(3, 1)));
		assertFalse(worldMap.contains(new Point(1, -1)));
		assertFalse(worldMap.contains(new Point(1, 3)));
	}

}
