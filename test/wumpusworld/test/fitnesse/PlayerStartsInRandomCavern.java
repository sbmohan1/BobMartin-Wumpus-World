package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class PlayerStartsInRandomCavern {
	
	private static int width, height;
	private static Map worldMap;
	private static java.util.Map<Point, Integer> startingPositions;
	private static int x, y;
	
	public void cavern(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
	}
	
	public void setWidth(int width) {
		PlayerStartsInRandomCavern.width = width;
	}

	public void setHeight(int height) {
		PlayerStartsInRandomCavern.height = height;
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
	
	public boolean occurrences(int x, int y, int minAmount) {
		Point p = new Point(x, y);
		return startingPositions.getOrDefault(p, 0) >= minAmount;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
