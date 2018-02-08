package wumpusworld.test.junit;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.PlayerPositionStrategy;
import wumpusworld.WumpusPositionStrategy;

public class WumpusPositionStrategyTest {
	@Test
	public void positionIsNeverPlayerLocation() {
		WumpusPositionStrategy strategy = new WumpusPositionStrategy();
		PlayerPositionStrategy playerStrategy = new PlayerPositionStrategy();
		Map worldMap = new Map(2, 2);
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		int sameAsPlayer = 0;
		int differentThanPlayer = 0;
		
		for (int i=0; i < 100; i++) {
			Game game = new Game(worldMap);
			game.setPlayerLocation();
			Point playerPosition = game.getPlayerLocation();
			game.setWumpusPosition();
			Point wumpusPosition = game.getWumpusLocation();
			if (wumpusPosition.equals(playerPosition)) {
				sameAsPlayer++;
			}
			else {
				differentThanPlayer++;
			}
		}
		assertTrue(sameAsPlayer == 0);
		assertTrue(differentThanPlayer == 100);
	}
	
}
