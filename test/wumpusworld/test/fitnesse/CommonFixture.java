package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class CommonFixture {
	protected static int width, height;
	protected static Map worldMap;
	
	public void resetStatic() {
		width = 0;
		height = 0;
		worldMap = null;
	}
	
	public void setWidth(int width) {
		CommonFixture.width = width;
	}
	
	public void setHeight(int height) {
		CommonFixture.height = height;
	}
	
	public void cavern(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		worldMap.addCavern(x, y);
	}
	
	public void bats(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		worldMap.addBats(x, y);
	}
	
	public void pit(int x, int y) {
		if (worldMap == null) {
			worldMap = new Map(width, height);
		}
		worldMap.addPit(x, y);
	}
}
