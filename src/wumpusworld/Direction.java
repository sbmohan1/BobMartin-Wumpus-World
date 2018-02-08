package wumpusworld;

import java.awt.Point;

public enum Direction {
	NORTH(0, -1),
	WEST(-1, 0),
	SOUTH(0, 1),
	EAST(1, 0);
	
	public final int x;
	public final int y;
	
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point getPoint(Point origin) {
		return new Point(origin.x + x, origin.y + y);
	}
}