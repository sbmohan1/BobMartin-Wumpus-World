package wumpusworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Map worldMap;
	private Point wumpusLocation;
	private Point playerPosition;
	private int playerArrows = 5;

	public Game(Map worldMap) {
		this.worldMap = worldMap;
		this.wumpusLocation = new Point(-1, -1);
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		playerPosition = strategy.getPoint(this);
	}
	
	private Game(Map worldMap, Point wumpusLocation) {
		this.wumpusLocation = wumpusLocation;
		this.worldMap = worldMap;
		PlayerPositionStrategy strategy = new PlayerPositionStrategy();
		playerPosition = strategy.getPoint(this);
	}

	public Point getPlayerPosition() {
		return playerPosition;
	}
	
	public void setWumpusPosition() {
		WumpusPositionStrategy strategy = new WumpusPositionStrategy();
		wumpusLocation =  strategy.getPoint(this);
	}

	public Point retrieveWumpusPosition() {
		return wumpusLocation;
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
			if (worldMap.contains(p) && worldMap.isCavern(p.x, p.y)) {
				directions.add(d);
			}
		}
		return directions;
	}


	public void move(Direction d) throws NoDoorException {
		Point newPos = new Point(playerPosition.x + d.x, playerPosition.y + d.y);
		if (!worldMap.contains(newPos) || !worldMap.isCavern(newPos.x, newPos.y)) {
			throw new NoDoorException();
		}
		playerPosition = newPos;

	}

	public void shootArrow(Direction north) {
		playerArrows--;
	}

	public int getNumberOfArrows() {
		return playerArrows;
	}

}
