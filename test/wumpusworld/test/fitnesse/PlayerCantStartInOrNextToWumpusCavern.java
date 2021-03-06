package wumpusworld.test.fitnesse;



import java.awt.Point;
import java.util.HashMap;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.Game.GameBuilder;

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
			GameBuilder gameBuilder = new GameBuilder();
			gameBuilder.setWorldMap(worldMap);
			gameBuilder.setWumpusLocation(wumpusLocation);
			Game game = gameBuilder.build();
//			game.setWumpusLocation(wumpusLocation.x, wumpusLocation.y);
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
