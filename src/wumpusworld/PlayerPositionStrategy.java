package wumpusworld;

import java.awt.Point;

public class PlayerPositionStrategy {

	public Point getPoint(Game game) {
		int x, y;
		do {
			x = (int)(Math.random() * game.getWorldMap().getWidth());
			y = (int)(Math.random() * game.getWorldMap().getHeight());
		} while((game.getWumpusLocation().x == x && game.getWumpusLocation().y == y) || game.getWorldMap().isBats(x, y) || game.getWorldMap().isPit(x, y)  || !game.getWorldMap().isCavern(x, y));
		return new Point(x, y);
	}

}
