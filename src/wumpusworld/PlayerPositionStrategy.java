package wumpusworld;

import java.awt.Point;

public class PlayerPositionStrategy {

	public Point getPoint(Game game) {
		int x, y;
		do {
			x = (int)(Math.random() * game.getWorldMap().getWidth());
			y = (int)(Math.random() * game.getWorldMap().getHeight());
		} while(isWithWumpus(game, x,  y) || isNextToWumpus(game, x, y) || game.getWorldMap().isBats(x, y) || game.getWorldMap().isPit(x, y)  || !game.getWorldMap().isCavern(x, y));
		return new Point(x, y);
	}
	
	public boolean isWithWumpus(Game game, int x, int y) {
		Point testPoint = new Point(x, y);
		int wumpusX = game.getWumpusLocation().x;
		int wumpusY = game.getWumpusLocation().y;
		Point wumpusPoint = new Point(wumpusX, wumpusY);
		if(testPoint.equals(wumpusPoint)) {
			return true;
		}
		return false;
	}
	
	public boolean isNextToWumpus(Game game, int x, int y) {
		Point testPoint = new Point(x, y);
		int wumpusX = game.getWumpusLocation().x;
		int wumpusY = game.getWumpusLocation().y;
		Point leftOfWumpus = new Point(wumpusX - 1, wumpusY);
		Point rightOfWumpus = new Point(wumpusX + 1, wumpusY);
		Point belowWumpus = new Point(wumpusX, wumpusY+1);
		Point aboveWumpus = new Point(wumpusX, wumpusY-1);
		if(testPoint.equals(leftOfWumpus) || testPoint.equals(rightOfWumpus) || testPoint.equals(aboveWumpus) || testPoint.equals(belowWumpus)) {
			return true;
		}
		return false;
	}

}
