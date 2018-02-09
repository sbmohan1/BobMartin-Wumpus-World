package wumpusworld.test.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.PlayerPositionStrategy;

public class PlayerPositionStrategyTest {
	@Test
	public void positionIsNeverWumpusLocation() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
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
		
		java.util.Map<Point, Integer> occurrences = new HashMap<>();
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(1,1);
			Point playerPosition = strategy.getPoint(game);
			occurrences.put(playerPosition, occurrences.getOrDefault(playerPosition, 0) + 1);
		}
		assertFalse(occurrences.containsKey(new Point(1, 0)));
		assertFalse(occurrences.containsKey(new Point(1, 2)));
		assertFalse(occurrences.containsKey(new Point(0, 1)));
		assertFalse(occurrences.containsKey(new Point(2, 1)));
		assertFalse(occurrences.containsKey(new Point(1, 1)));
	}
	
	@Test
	public void positionIsNeverBatsLocation() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addBats(1, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = strategy.getPoint(game);
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 100);
		assertTrue(secondCellCount == 0);

		firstCellCount = 0;
		secondCellCount = 0;
		
		worldMap.addCavern(1, 0);
		worldMap.addBats(0, 0);
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = strategy.getPoint(game);
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
	public void positionIsNeverPitLocation() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addPit(1, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = strategy.getPoint(game);
			if (playerPosition.x == 0) {
				firstCellCount++;
			}
			else {
				secondCellCount++;
			}
		}
		assertTrue(firstCellCount == 100);
		assertTrue(secondCellCount == 0);

		firstCellCount = 0;
		secondCellCount = 0;
		
		worldMap.addCavern(1, 0);
		worldMap.addPit(0, 0);
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = strategy.getPoint(game);
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
	public void positionIsAlwaysInCavern() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 1);
		worldMap.addCavern(0, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			Point playerPosition = strategy.getPoint(game);
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
	
	@Test(expected = Exception.class)
	public void ifNoValidPosition_throwException() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 1);
		Game game = new Game(worldMap);
		strategy.getPoint(game);
	}
	
	
}
