package wumpusworld.test.junit;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.PlayerPositionStrategy;

public class PlayerPositionStrategyTest {
	@Test
	public void positionIsNeverWumpusLocation() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 2);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		int firstCellCount = 0;
		int secondCellCount = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(1,0);
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
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(0,0);
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
	
}
