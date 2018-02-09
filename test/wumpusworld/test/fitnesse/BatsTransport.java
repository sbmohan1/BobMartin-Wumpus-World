package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class BatsTransport extends CommonPlayerMovementFixture {
	protected static java.util.Map<Point, Integer> transportedPositions;
	protected static String movementDirection;
	protected static Point playerPos;
	
	public void resetStatic() {
		transportedPositions = null;
		movementDirection = null;
		playerPos = null;
	}
	
	public void setMove(String s) {
		movementDirection = s;
		super.setMove(s);
	}
	
	public void setPlayerPosition(int x, int y) {
		playerPos = new Point(x, y);
		super.setPlayerPosition(x, y);
	}
	
	public void run(int times) {
		transportedPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		for (int i=0; i< times; i++) {
			super.setPlayerPosition(playerPos.x, playerPos.y);
			super.setMove(movementDirection);
			Point pos = game.getPlayerPosition();
			if (transportedPositions.containsKey(pos)) {
				transportedPositions.put(pos, transportedPositions.get(pos) + 1);
			}
			else {
				transportedPositions.put(pos, 1);
			}
		}
	}
	
	public boolean occurrences(int x, int y, int minAmount, int maxAmount) {
		Point p = new Point(x, y);
		int amount = transportedPositions.getOrDefault(p, 0);
		return amount >= minAmount && amount <= maxAmount;
	}
}
