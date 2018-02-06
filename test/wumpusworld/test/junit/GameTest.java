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
		Game game = new Game(worldMap);
		Point playerPosition = game.getPlayerPosition();
		assertEquals(0, playerPosition.x);
		assertEquals(0, playerPosition.y);
		
		
	}
	
	@Test
	public void onNewGame_returnPlayerPositionWhenMapIsTwoCells() {
		Map worldMap = new Map(2, 2);
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
	

}