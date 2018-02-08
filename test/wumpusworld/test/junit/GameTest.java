package wumpusworld.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Game.Direction;
import wumpusworld.Map;

public class GameTest {
	
	@Test
	public void onNewGame_returnPlayerPositionWhenMapIsOneCell() {
		Map worldMap = new Map(1, 1);
		worldMap.addCavern(0, 0);
		Game game = new Game(worldMap);
		Point playerPosition = game.getPlayerPosition();
		assertEquals(0, playerPosition.x);
		assertEquals(0, playerPosition.y);
	}
	
	@Test
	public void onNewGame_returnPlayerPositionWhenMapIsTwoCells() {
		Map worldMap = new Map(2, 2);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(0, 1);
		Game game = new Game(worldMap);
		Point playerPosition = game.getPlayerPosition();
		assertTrue(playerPosition.x > -1 && playerPosition.x < 2);
		assertTrue(playerPosition.y > -1 && playerPosition.y < 2);
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition() {
		Map worldMap = new Map(2, 1);
		int firstCellCount = 0;
		int secondCellCount = 0;
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		int lowerBound = 30;
		assertTrue(firstCellCount > lowerBound);
		assertTrue(secondCellCount > lowerBound);
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition_ExcludesBatCaves() {
		Map worldMap = new Map(2, 1);
		worldMap.addBats(0, 0);
		worldMap.addCavern(1, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 0);
		assertTrue(secondCellCount == 100);
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition_ExcludePitCaves() {
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		worldMap.addPit(1, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 100);
		assertTrue(secondCellCount == 0);
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition_ExcludesNonCaverns() {
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 100);
		assertTrue(secondCellCount == 0);
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition_ExcludesWumpusLocation() {
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(1,0);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 100);
		assertTrue(secondCellCount == 0);
	}
	
	@Test
	public void testGetAvailableDirections_NWSE() {
		Map worldMap = new Map(3, 3);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(2, 1);
		worldMap.addCavern(0, 2);
		worldMap.addCavern(1, 2);
		worldMap.addCavern(2, 2);
		
		Game game = new Game(worldMap);
		game.setWumpusLocation(1,0);
		game.setPlayerPosition(new Point(1, 1));
		
		List<Direction> expected = new ArrayList<>();
		expected.add(Direction.NORTH);
		expected.add(Direction.WEST);
		expected.add(Direction.SOUTH);
		expected.add(Direction.EAST);
		
		assertEquals(expected, game.getAvailableDirections());
	}
	
	@Test
	public void testGetAvailableDirections_None() {
		Map worldMap = new Map(1, 1);
		
		worldMap.addCavern(0, 0);
		
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(0, 0));
		
		List<Direction> expected = new ArrayList<>();
		
		assertEquals(expected, game.getAvailableDirections());
	}
	
	@Test
	public void testGetAvailableDirections_NoWest() {
		Map worldMap = new Map(3, 3);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(2, 1);
		worldMap.addCavern(0, 2);
		worldMap.addCavern(1, 2);
		worldMap.addCavern(2, 2);
		
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(0, 1));
		
		List<Direction> expected = new ArrayList<>();
		expected.add(Direction.NORTH);
		expected.add(Direction.SOUTH);
		expected.add(Direction.EAST);
		
		assertEquals(expected, game.getAvailableDirections());
	}
	
	@Test
	public void testGetAvailableDirections_NoNorth() {
		Map worldMap = new Map(3, 3);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(2, 1);
		worldMap.addCavern(0, 2);
		worldMap.addCavern(1, 2);
		worldMap.addCavern(2, 2);
		
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 0));
		
		List<Direction> expected = new ArrayList<>();
		expected.add(Direction.WEST);
		expected.add(Direction.SOUTH);
		expected.add(Direction.EAST);
		
		assertEquals(expected, game.getAvailableDirections());
	}

}
