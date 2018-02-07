package wumpusworld;

import java.awt.Point;

public class Game {
	
	private Map worldMap;
	private Point wumpusLocation;

	public Game(Map worldMap) {
		this.worldMap = worldMap;
		wumpusLocation = new Point(-1, -1);
	}

	public Point getPlayerPosition() {
		int x, y;
		do {
			x = (int)(Math.random() * worldMap.getWidth());
			y = (int)(Math.random() * worldMap.getHeight());
		} while(worldMap.isBats(x, y) || worldMap.isPit(x, y) || !worldMap.isCavern(x, y) || (wumpusLocation.x == x && wumpusLocation.y == y));
		return new Point(x, y);
	}

	public void setWumpusLocation(int x, int y) {
		wumpusLocation = new Point(x, y);
	}

	public Point getWumpusLocation() {
		// TODO Auto-generated method stub
		return wumpusLocation;
	}

	public Map getWorldMap() {
		// TODO Auto-generated method stub
		return worldMap;
	}

}
