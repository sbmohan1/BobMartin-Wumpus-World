package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class CommonPlayerStartingPositionFixture {
	protected static int width, height;
	protected static Map worldMap;
	protected static java.util.Map<Point, Integer> startingPositions;
	
	public void reset() {
		width = 0;
		height = 0;
		worldMap = null;
		startingPositions = null;
	}
	
	public void setWidth(int width) {
		CommonPlayerStartingPositionFixture.width = width;
	}
	
	public void setHeight(int height) {
		CommonPlayerStartingPositionFixture.height = height;
	}
	
	public void cavern(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		worldMap.addCavern(x, y);
	}
	
	public void bats(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		worldMap.addBats(x, y);
	}
	
	public void run(int times) {
		startingPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(CommonPlayerStartingPositionFixture.width, CommonPlayerStartingPositionFixture.height);
		}
		for (int i=0; i< times; i++) {
			Game game = new Game(worldMap);
			Point pos = game.getPlayerPosition();
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