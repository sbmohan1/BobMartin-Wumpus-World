package wumpusworld.test.fitnesse;



import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;

public class PlayerCantStartInOrNextToWumpusCavern extends CommonPlayerStartingPositionFixture {
	
	
	protected static Point wumpusLocation;
	
	public void cavernWithWumpus(int x, int y) {
		wumpusLocation = new Point(x, y);
		cavern(x,y);
	}
	
	public void run(int times) {
		startingPositions = new HashMap<>();
		if (worldMap == null) {
			worldMap = new Map(CommonPlayerStartingPositionFixture.width, CommonPlayerStartingPositionFixture.height);
		}
		for (int i=0; i< times; i++) {
			Game game = new Game(worldMap);
			game.setWumpusLocation(wumpusLocation.x, wumpusLocation.y);
			Point pos = game.getPlayerPosition();
			if (startingPositions.containsKey(pos)) {
				startingPositions.put(pos, startingPositions.get(pos) + 1);
			}
			else {
				startingPositions.put(pos, 1);
			}
		}
	}
}
