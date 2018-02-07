package wumpusworld;

import java.awt.Point;

public class Game {
	
	private Map worldMap;
	private Point wumpusLocation;

	public Game(Map worldMap) {
		this.worldMap = worldMap;
		this.wumpusLocation = new Point(-1, -1);
	}
	
	private Game(Map worldMap, Point wumpusLocation) {
		this.wumpusLocation = wumpusLocation;
		this.worldMap = worldMap;
	}

	public Point getPlayerPosition() {
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		return strategy.getPoint(this);
	}

	public void setWumpusLocation(int x, int y) {
		wumpusLocation = new Point(x, y);
	}

	public Point getWumpusLocation() {
		return wumpusLocation;
	}

	public Map getWorldMap() {
		return worldMap;
	}
	
	public static class GameBuilder{
		private Point wumpusLocation;
		private Map worldMap;
		
		public void setWumpusLocation(Point wumpusLocation) {
			this.wumpusLocation = wumpusLocation;
		}
		
		public void setWorldMap(Map worldMap) {
			this.worldMap = worldMap;
		}
		
		public Game build() {
			return new Game(worldMap, wumpusLocation);
		}
	}

}
