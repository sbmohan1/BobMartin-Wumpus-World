package wumpusworld;

import java.awt.Point;

public class Game {
	
	private Map worldMap;

	public Game(Map worldMap) {
		this.worldMap = worldMap;
	}

	public Point getPlayerPosition() {
		// TODO Auto-generated method stub
		int x = (int)(Math.random() * worldMap.getWidth());
		int y = (int)(Math.random()* worldMap.getHeight());
		return new Point(x, y);
	}

}
