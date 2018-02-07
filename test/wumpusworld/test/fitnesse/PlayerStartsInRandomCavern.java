package wumpusworld.test.fitnesse;

import java.awt.Point;

public class PlayerStartsInRandomCavern extends CommonPlayerStartingPositionFixture {
	
	public boolean occurrences(int x, int y, int minAmount) {
		Point p = new Point(x, y);
		return startingPositions.getOrDefault(p, 0) >= minAmount;
	}
}
