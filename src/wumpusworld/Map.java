package wumpusworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Map {
	
	private enum CELL_TYPE {
		EMPTY,
		CAVERN
	}
	
	private int width;
	private int height;
	private CELL_TYPE[][] grid;
	
	public Map(int width, int height) {
		grid = new CELL_TYPE[width][];
		for (int i=0; i < width; i++) {
			grid[i] = new CELL_TYPE[height];
		}
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addCavern(int x, int y) {
		grid[x][y] = CELL_TYPE.CAVERN;
	}

	public boolean isCavern(int x, int y) {
		return grid[x][y] == CELL_TYPE.CAVERN;
	}

}
