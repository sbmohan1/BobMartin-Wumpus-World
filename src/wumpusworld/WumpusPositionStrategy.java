package wumpusworld;

import java.awt.Point;

public class WumpusPositionStrategy {
	public Point getPoint(Game game) {
		int x, y;
		do {
			x = (int)(Math.random() * game.getWorldMap().getWidth());
			y = (int)(Math.random() * game.getWorldMap().getHeight());
		} while(!game.getWorldMap().isCavern(x, y));
		return new Point(x, y);
	}
}
