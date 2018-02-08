package wumpusworld.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import wumpusworld.Game;
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
		Map worldMap = new Map(3, 1);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		int firstCellCount = 0;
		int secondCellCount = 0;
		int thirdCellCount = 0;

		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(0,0);
			Point playerPosition = game.getPlayerPosition();
			if (playerPosition.x == 2) {
				thirdCellCount++;
			}
			else if(playerPosition.x == 1) {
				secondCellCount++;
			}
			else if(playerPosition.x == 0){
				firstCellCount++;
			}
			
		}
		assertTrue(firstCellCount == 0);
		assertTrue(secondCellCount == 0);
		assertTrue(thirdCellCount == 100);
		
		
	}
	
	@Test
	public void onNewGame_PlayerIsGivenRandomPosition_ExcludesNextToWumpusLocation() {
		Map worldMap = new Map(4,4);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(3, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(0, 2);
		worldMap.addCavern(0, 3);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(1, 2);
		worldMap.addCavern(1, 3);
		worldMap.addCavern(2, 1);
		worldMap.addCavern(2, 2);
		worldMap.addCavern(2, 2);
		worldMap.addCavern(2, 3);
		worldMap.addCavern(3, 1);
		worldMap.addCavern(3, 2);
		worldMap.addCavern(3, 3);
		Point aboveWumpus = new Point(2, 1);
		Point belowWumpus = new Point(2, 3);
		Point leftOfWumpus = new Point(1, 2);
		Point rightOfWumpus = new Point(3, 2);
		int aboveCount = 0;
		int belowCount = 0;
		int leftCount = 0;
		int rightCount = 0;
		int anyOtherCount = 0;

		
		for(int i = 0; i <100; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(2, 2);
			Point playerPosition = game.getPlayerPosition();
			if(playerPosition.equals(aboveWumpus)) {
				aboveCount++;
			}
			else if(playerPosition.equals(belowWumpus)) {
				belowCount++;
			}
			else if(playerPosition.equals(leftOfWumpus)) {
				leftCount++;
			}
			else if(playerPosition.equals(rightOfWumpus)) {
				rightCount++;
			}
			else {
				anyOtherCount++;
			}
			
		}
		
		assertTrue(aboveCount == 0);
		assertTrue(belowCount == 0);
		assertTrue(leftCount == 0);
		assertTrue(rightCount == 0);
		assertTrue(anyOtherCount == 100);
		
	}

}
