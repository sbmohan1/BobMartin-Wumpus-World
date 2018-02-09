package wumpusworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Map {
	
	public enum CELL_TYPE {
		EMPTY, 
		CAVERN,
		PIT,
		BATS
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


	public void addCavern(int x, int y) {
		grid[x][y] = CELL_TYPE.CAVERN;
	}

	public boolean isCavern(int x, int y) {
		return grid[x][y] == CELL_TYPE.CAVERN;
	}
	
	public void addPit(int x, int y) {
		grid[x][y] = CELL_TYPE.PIT;
	}
	
	public boolean isPit(int x, int y) {
		return grid[x][y] == CELL_TYPE.PIT;
	}

	public void addBats(int x, int y) {
		grid[x][y] = CELL_TYPE.BATS;
	}
	
	public boolean isBats(int x, int y) {
		return grid[x][y] == CELL_TYPE.BATS;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}


	public boolean contains(Point point) {
		return point.x >= 0 
			&& point.x < width 
			&& point.y >= 0 
			&& point.y < height;
	}


	public List<Point> getCaverns() {
		List<Point> caverns = new ArrayList<>();
		for (int x=0; x < width; x++) {
			for (int y=0; y < height; y++) {
				if (grid[x][y] == CELL_TYPE.CAVERN)
					caverns.add(new Point(x, y));
			}
		}
		return caverns;
	}
}
