package wumpusworld;

import java.awt.Point;

public class WumpusPositionStrategy {
	public Point getPoint(Game game) {
		int x, y;
		do {
			x = (int)(Math.random() * game.getWorldMap().getWidth());
			y = (int)(Math.random() * game.getWorldMap().getHeight());
		} while(isWithPlayer(game, x, y) || isNextToPlayer(game, x, y) || !game.getWorldMap().isCavern(x, y));
		return new Point(x, y);
	}
	
	public boolean isWithPlayer(Game game, int x, int y) {
		Point testPoint = new Point(x, y);
		int playerX = game.getPlayerPosition().x;
		int playerY = game.getPlayerPosition().y;
		Point playerPoint = new Point(playerX, playerY);
		if(testPoint.equals(playerPoint)) {
			return true;
		}
		return false;
	}
	
	public boolean isNextToPlayer(Game game, int x, int y) {
		Point testPoint = new Point(x, y);
		int playerX = game.getPlayerPosition().x;
		int playerY = game.getPlayerPosition().y;
		Point leftOfPlayer = new Point(playerX - 1, playerY);
		Point rightOfPlayer = new Point(playerX + 1, playerY);
		Point belowPlayer = new Point(playerX, playerY+1);
		Point abovePlayer = new Point(playerX, playerY-1);
		if(testPoint.equals(leftOfPlayer) || testPoint.equals(rightOfPlayer) || testPoint.equals(abovePlayer) || testPoint.equals(belowPlayer)) {
			return true;
		}
		return false;
	}

	
}
