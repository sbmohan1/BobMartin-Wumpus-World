package wumpusworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	public enum Direction {
		NORTH(0, -1),
		WEST(-1, 0),
		SOUTH(0, 1),
		EAST(1, 0);
		
		private int x, y;
		
		private Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point getPoint(Point origin) {
			return new Point(origin.x + x, origin.y + y);
		}
	}
	
	private Map worldMap;
	private Point wumpusLocation;
	private Point playerPosition;

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
		playerPosition = strategy.getPoint(this);
		return playerPosition;
	}
	
	public Point getWumpusPosition() {
		WumpusPositionStrategy strategy = new WumpusPositionStrategy();
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
	
	public void setPlayerPosition(Point p) {
		playerPosition = p;
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

	public List<Direction> getAvailableDirections() {
		List<Direction> directions = new ArrayList<>();
		for (Direction d : Direction.values()) {
			Point p = d.getPoint(playerPosition);
			if (worldMap.contains(p)) {
				directions.add(d);
			}
		}
		return directions;
	}

	public void move(Direction d) throws NoDoorException {
		Point newPos = new Point(playerPosition.x + d.x, playerPosition.y + d.y);
		if (!worldMap.isCavern(newPos.x, newPos.y)) {
			throw new NoDoorException();
		}
		playerPosition = newPos;
	}

}
