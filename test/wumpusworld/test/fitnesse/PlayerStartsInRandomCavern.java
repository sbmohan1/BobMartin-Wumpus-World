package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class PlayerStartsInRandomCavern {
	private int width, height;
	private Map worldMap;
	private java.util.Map<Point, Integer> startingPositions;
	
	public void cavern(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void run(int times) {
		startingPositions = new HashMap<>();
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
	
	public int occurrences(int x, int y) {
		Point p = new Point(x, y);
		return startingPositions.getOrDefault(p, 0);
	}
}
