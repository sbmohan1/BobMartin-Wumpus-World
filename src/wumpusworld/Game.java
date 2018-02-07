package wumpusworld;

import java.awt.Point;

public class Game {
	
	private Map worldMap;

	public Game(Map worldMap) {
		this.worldMap = worldMap;
	}

	public Point getPlayerPosition() {
		int x, y;
		do {
			x = (int)(Math.random() * worldMap.getWidth());
			y = (int)(Math.random() * worldMap.getHeight());
		} while(worldMap.isBats(x, y));
		return new Point(x, y);
	}

}
