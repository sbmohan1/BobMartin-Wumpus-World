package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class WumpusStartsInRandomCavern extends CommonPlayerStartingPositionFixture {

	public void run(int times) {
		startingPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(CommonPlayerStartingPositionFixture.width, CommonPlayerStartingPositionFixture.height);
		}
		for (int i=0; i< times; i++) {
			Game game = new Game(worldMap);
			Point pos = game.getWumpusLocation();
			if (startingPositions.containsKey(pos)) {
				startingPositions.put(pos, startingPositions.get(pos) + 1);
			}
			else {
				startingPositions.put(pos, 1);
			}
		}
	}
	
	public boolean occurrences(int x, int y, int minAmount, int maxAmount) {
		Point p = new Point(x, y);
		int amount = startingPositions.getOrDefault(p, 0);
		return amount >= minAmount && amount <= maxAmount;
	}
}
