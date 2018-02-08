package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class WumpusCantStartInPlayerCavern extends CommonPlayerStartingPositionFixture {
	
	protected static Point playerLocation;
	
	public void cavernWithPlayer(int x, int y) {
		playerLocation = new Point(x,y);
		cavern(x,y);
	}
	public void run(int times) {
		startingPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(CommonPlayerStartingPositionFixture.width, CommonPlayerStartingPositionFixture.height);
		}
		for (int i=0; i< times; i++) {
			Game game = new Game(worldMap);
			Point pos = game.getWumpusLocation();
			if (startingPositions.containsKey(pos)) {
				startingPositions.put(pos, startingPositions.get(pos) + 1);
			}
			else {
				startingPositions.put(pos, 1);
			}
		}
	}

}
