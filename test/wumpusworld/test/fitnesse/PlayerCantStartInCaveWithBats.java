package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class PlayerCantStartInCaveWithBats {
	private static int width, height;
	private static Map worldMap;
	private static java.util.Map<Point, Integer> startingPositions;
	
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
	
	public void setWidth(int width) {
		PlayerCantStartInCaveWithBats.width = width;
	}

	public void setHeight(int height) {
		PlayerCantStartInCaveWithBats.height = height;
	}
	
	public void run(int times) {
		startingPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(width, height);
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